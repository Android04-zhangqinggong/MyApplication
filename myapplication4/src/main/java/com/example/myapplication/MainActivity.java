package com.example.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler;
    int count = 100;
    private ProgressBar mBar;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBar = (ProgressBar) findViewById(R.id.bar);
        mBar.setMax(100);
        mBar.setProgress(100);
        mTv = (TextView) findViewById(R.id.tv);
        mHandler = new MyHandler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(count >= 0){
                    mHandler.sendEmptyMessage(0);//发送数据
                    try {
                        Thread.sleep(1000);
                        count--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }).start();
    }
    class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 0){//接收数据
                mBar.setProgress(count);
                mTv.setText(count + "");
            }
        }
    }

}
