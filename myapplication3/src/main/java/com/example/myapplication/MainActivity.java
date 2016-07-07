package com.example.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    Button btn;
    private String[] mStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button1);
        Animation a =  AnimationUtils.loadAnimation(this, R.anim.anim);
        btn.startAnimation(a);
        btn.setOnClickListener(this);
        Log.d(TAG, "onCreate: 执行了");
    }

    @Override
    public void onClick(View v) {
        //showDiolog();
        showSingleItem();
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
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle("提示对话框");
        b.setMessage("是否确认退出");
        b.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        b.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        b.show();
    }

}