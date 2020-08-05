package payinfomation;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.happytravel.R;
public class PIHorizontalScroll extends Activity{

    List<DateItem> dateList;
    RelativeLayout itmel;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pay_information);
        LayoutInflater layoutInflater = (LayoutInflater) this
                .getSystemService(LAYOUT_INFLATER_SERVICE);
        gridView = (GridView) findViewById(R.id.grid);
        setData();
        setGridView();
    }
    /**设置数据*/
    private void setData() {
        dateList = new ArrayList<DateItem>();
        DateItem item = new DateItem();
        item.setDateName("7月20日");
        dateList.add(item);
        item = new DateItem();
        item.setDateName("7月21日");
        dateList.add(item);
        item = new DateItem();
        item.setDateName("7月22日");
        dateList.add(item);
        item = new DateItem();
        item.setDateName("7月23日");
        dateList.add(item);
        item = new DateItem();
        item.setDateName("7月24日");
        dateList.add(item);
        item = new DateItem();
        item.setDateName("7月25日");

        dateList.add(item);
        dateList.addAll(dateList);
    }
    private void setGridView() {
        int size = dateList.size();
        int length = 100;
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        int gridviewWidth = (int) (size * (length + 4) * density);
        int itemWidth = (int) (length * density);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                gridviewWidth, LinearLayout.LayoutParams.FILL_PARENT);
        gridView.setLayoutParams(params); // 设置GirdView布局参数,横向布局的关键
        gridView.setColumnWidth(itemWidth); // 设置列表项宽
        gridView.setHorizontalSpacing(5); // 设置列表项水平间距
        gridView.setStretchMode(GridView.NO_STRETCH);
        gridView.setNumColumns(size); // 设置列数量=列表集合数

        GridViewAdapter adapter = new GridViewAdapter(getApplicationContext(),
                dateList);
        gridView.setAdapter(adapter);
    }
    public class GridViewAdapter extends BaseAdapter {
        Context context;
        List<DateItem> list;
        public GridViewAdapter(Context _context, List<DateItem> _list) {
            this.list = _list;
            this.context = _context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int date) {
            return list.get(date);
        }

        @Override
        public long getItemId(int date) {
            return date;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(R.layout.date_list_item, null);
            TextView tvDate = (TextView) convertView.findViewById(R.id.pi_date);

            DateItem date = list.get(position);

            tvDate.setText(date.getDate());
            return convertView;
        }
    }

    public class DateItem {
        private String date;

        public String getDate() {
            return date;
        }

        public void setDateName(String date) {
            this.date = date;
        }


    }





}
