package com.example.myapplication;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {
    private static final String TAG = "MainActivity";
    Button btn;
    private String[] mStr;
    private AlertDialog.Builder mB;
    Calendar c = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button1);
        Animation a = AnimationUtils.loadAnimation(this, R.anim.anim);
        btn.startAnimation(a);
        btn.setOnClickListener(this);
        Log.d(TAG, "onCreate: 执行了");
    }

    @Override
    public void onClick(View v) {
        //showDiolog();
        //showProgressDialog();
        //showProgressDiaolog2();
        timePickerDialog();

    }

    private void timePickerDialog() {
        //日期设置对话框
        /*DatePickerDialog d = new DatePickerDialog(this,this,c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH));
        d.show();*/
        //时间设置对话框
        TimePickerDialog t = new TimePickerDialog(this,this,c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),false);
        t.show();
    }

    private void showProgressDiaolog2() {
        final ProgressDialog p = new ProgressDialog(this);
        p.setMessage("正在加载,请稍后...");
        p.setTitle("精确进度对话框");
        p.setCancelable(false);
        p.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        p.setProgress(0);//设置初始值
        p.setMax(100);//设置最大值
        p.setSecondaryProgress(p.getProgress() + 10);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(p.getProgress() < p.getMax()){
                    p.setProgress(p.getProgress() + 10);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
               p.dismiss();
            }
        }).start();
        p.setButton(ProgressDialog.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                p.dismiss();
            }
        });
        p.show();
    }

    //模糊进度对话框
    private void showProgressDialog() {
        ProgressDialog p = new ProgressDialog(this);
        p.setMessage("正在加载,请稍后...");
        p.setTitle("进度对话框");
        p.setCancelable(false);
        p.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        p.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        p.show();
    }

    //单选对话框
    private void showSingleItem() {
        mStr = new String[]{"苹果", "香蕉", "橘子"};
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("单选对话框");
        b.setSingleChoiceItems(mStr, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "您选中了" + mStr[which], Toast.LENGTH_SHORT).show();
            }
        });
        b.show();

    }

    //提示对话框
    private void showDiolog() {
        mB = new AlertDialog.Builder(this);


        mB.setTitle("提示对话框");
        mB.setMessage("是否确认退出");
        mB.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        mB.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        mB.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        c.set(year,monthOfYear,dayOfMonth);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        c.set(Calendar.HOUR_OF_DAY,hourOfDay);
        c.set(Calendar.MINUTE,minute);
    }
}