package com.example.happytravel.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

import androidx.appcompat.app.AppCompatActivity;

import com.baidu.location.BDLocation;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.example.happytravel.R;
import com.example.happytravel.constant.baidu_SearchPlaceConstant;
import com.example.happytravel.location.baidu_BDLocationManager;
import com.example.happytravel.utils.baidu_ConverterUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @author ysx
 *         地图Activity
 */
public class baidu_MapActivity extends AppCompatActivity implements
        BaiduMap.OnMarkerClickListener {
    private static final String TAG = "baidu_MapActivity";

    @BindView(R.id.map_view)
    MapView mMapView;
    @BindView(R.id.iv_search)
    ImageView mIvSearch;
    @BindView(R.id.iv_zoom_out)
    ImageView mIvZoomOut;
    @BindView(R.id.iv_zoom_in)
    ImageView mIvZoomIn;
    @BindView(R.id.iv_gps)
    ImageView mIvGps;

    private static final int REQUEST_CODE_SEARCH = 1;

    private BaiduMap mBaiduMap;
    /**
     * 是否首次定位
     */
    private boolean isFirstLoc = true;
    /**
     * 当前位置
     */
    private LatLng mCurrentLatLng;
    private static final float DEFAULT_ZOOM = 17f;
    private BitmapDescriptor mSearchBd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baidu_activity_map);
        ButterKnife.bind(this);
        initMapView();
        startLocation();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: ");
        mMapView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: ");
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        stopLocation();
        // 关闭定位图层
        mBaiduMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
        if (mSearchBd != null) {
            mSearchBd.recycle();
        }
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_SEARCH) {
            if (resultCode == Activity.RESULT_OK) {
                double latitude = data.getDoubleExtra(baidu_SearchPlaceConstant.EXTRA_LATITUDE, 0D);
                double longitude = data.getDoubleExtra(baidu_SearchPlaceConstant.EXTRA_LONGITUDE, 0D);
                LatLng latLng = new LatLng(latitude, longitude);

                Log.d(TAG, "onActivityResult: mLatLng: " + latLng);
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(latLng);
                MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(builder.build());
                mBaiduMap.setMapStatus(mapStatusUpdate);
                if (mSearchBd == null) {
                    mSearchBd = BitmapDescriptorFactory.fromResource(R.drawable.ic_location);
                }
                MarkerOptions option = new MarkerOptions().icon(mSearchBd).position(latLng);
                mBaiduMap.addOverlay(option);

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick({R.id.iv_search, R.id.iv_zoom_out, R.id.iv_zoom_in, R.id.iv_gps})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_search:
                Intent intent = new Intent(this, baidu_SearchPlaceActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SEARCH);
                break;
            case R.id.iv_zoom_out:
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.zoomOut());
                break;
            case R.id.iv_zoom_in:
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.zoomIn());
                break;
            case R.id.iv_gps:
                locToCurrentPosition(mBaiduMap, mCurrentLatLng, DEFAULT_ZOOM);
                break;
            default:
                break;
        }
    }

    /**
     * 初始化Baidu地图
     */
    private void initMapView() {
        mMapView.showZoomControls(false);
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMyLocationEnabled(true);
        View child = mMapView.getChildAt(1);
        if (child != null) {
            if (child instanceof ImageView || child instanceof ZoomControls) {
                child.setVisibility(View.INVISIBLE);
            }
        }
        mBaiduMap.setOnMarkerClickListener(this);

    }

    /**
     * 开始定位
     */
    private void startLocation() {
        baidu_BDLocationManager baiduBdLocationManager = baidu_BDLocationManager.getInstance();
        baiduBdLocationManager.init(this);
        baiduBdLocationManager.startLocation();
        baiduBdLocationManager.addLocationCallback(mLocationCallback);
    }

    /**
     * 停止定位
     */
    private void stopLocation() {
        baidu_BDLocationManager baiduBdLocationManager = baidu_BDLocationManager.getInstance();
        baiduBdLocationManager.removeLocationCallback(mLocationCallback);
        baiduBdLocationManager.stopLocation();

    }

    private baidu_BDLocationManager.LocationCallback mLocationCallback = new baidu_BDLocationManager.LocationCallback() {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            Log.v(TAG, "onReceiveLocation: ");
            // map view 销毁后不再处理新接收的位置
            if (bdLocation == null || mMapView == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(bdLocation.getRadius())
                    .latitude(bdLocation.getLatitude())
                    .longitude(bdLocation.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
            mCurrentLatLng = new LatLng(bdLocation.getLatitude(),
                    bdLocation.getLongitude());
            Log.v(TAG, "onReceiveLocation: mCurrentLatLng: " + mCurrentLatLng);
            LatLng bd09ll = mCurrentLatLng;
            LatLng gcj02 = baidu_ConverterUtils.BD09LLtoGCJ02(bd09ll);
            Log.d(TAG, "gcj02: " + gcj02 + ", bd09ll: " + bd09ll);
            if (isFirstLoc) {
                isFirstLoc = false;
                locToCurrentPosition(mBaiduMap, mCurrentLatLng, DEFAULT_ZOOM);
            }
        }
    };

    /**
     * 定位到当前位置
     */
    private void locToCurrentPosition(BaiduMap baiduMap, LatLng latLng,
                                      float zoom) {
        Log.d(TAG, "locToCurrentPosition: latLng: " + latLng);
        MapStatus.Builder builder = new MapStatus.Builder();
        builder.target(latLng).zoom(zoom);
        baiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Log.d(TAG, "onMarkerClick: marker: " + marker.getPosition());
        Toast.makeText(this, marker.getPosition().toString(), Toast.LENGTH_LONG).show();
        return false;
    }
}
