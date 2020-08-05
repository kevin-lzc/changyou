package com.example.happytravel;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.example.happytravel.Activity.baidu_MapActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ysx
 *         date 2017/10/27
 */
public class baidu_MainActivity extends AppCompatActivity {
    private static final String TAG = "baidu_MainActivity";

    /**
     * 所需的全部权限
     */
    private static final String[] PERMISSIONS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_PHONE_STATE,
    };

    private static final int[] REQUEST_PERMISSION_CODES = new int[]{
            1000,
            1001,
            1002,
            1003
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMapViewSDK();
        setContentView(R.layout.baidu_activity_map);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isAllPermissionGranted(this, PERMISSIONS)) {
            initMapViewSDK();
            startActivity(new Intent(this, baidu_MapActivity.class));
            finish();
        } else {
            requestLackedPermission();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // User agree the permission
            if (isAllPermissionGranted(this, PERMISSIONS)) {
                initMapViewSDK();
                startActivity(new Intent(this, baidu_MapActivity.class));
                finish();
            } else {
                requestLackedPermission();
            }
        } else {
            // User disagree the permission
            Toast.makeText(this, "缺少权限: " + permissions[0], Toast.LENGTH_LONG).show();
            finish();
        }
    }


    /**
     * 动态请求权限
     */
    private void requestLackedPermission() {
        for (int i = 0; i < PERMISSIONS.length; i++) {
            if (ContextCompat.checkSelfPermission(this, PERMISSIONS[i])
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        getLackedPermissions(this, PERMISSIONS), REQUEST_PERMISSION_CODES[i]);
                break;
            }
        }
    }

    /**
     * @param context
     * @param permissions
     * @return 是否获取到所有权限
     */
    public static boolean isAllPermissionGranted(Context context, String[] permissions) {
        for (int i = 0; i < permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(context, permissions[i])
                    != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }


    /**
     * @param context
     * @param rawPermissions
     * @return
     * 获取尚未获得的权限
     */
    public static String[] getLackedPermissions(Context context, String[] rawPermissions) {
        List<String> results = new ArrayList<>();
        for (String item : rawPermissions) {
            if (ContextCompat.checkSelfPermission(context, item)
                    != PackageManager.PERMISSION_GRANTED) {
                results.add(item);
            }
        }
        String[] resultPermissions = new String[results.size()];
        return results.toArray(resultPermissions);
    }

    /**
     * 初始化百度Map
     */
    private void initMapViewSDK() {
        SDKInitializer.initialize(getApplicationContext());
        /**
         * 使用百度经纬度坐标，与定位坐标类型一致
         */
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }
}
