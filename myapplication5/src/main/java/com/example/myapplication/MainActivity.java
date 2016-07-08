package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //定义listview,关联id
        ListView lv = (ListView) findViewById(R.id.tv);
        //定义适配器
        lv.setAdapter(new MyAdapter());
    }
    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 50;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv;
            if(convertView == null) {
                System.out.println("新建" + position);
                tv = new TextView(MainActivity.this);
            }else{
                System.out.println("复用" + position);
                tv = (TextView) convertView;
            }
            tv.setText("我是第" + position + "个View");
            return tv;
        }
    }
}
