package com.example.myapplication;

import android.view.View;

/**
 * Created by Administrator on 2016/7/7.
 */
public class Test {
    private String fruit;
    int num;

    public Test(String fruit, int num) {
        this.fruit = fruit;
        this.num = num;
        int[] x = {100,200};

    }

    public Test() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return "Test{" +
                "fruit='" + fruit + '\'' +
                '}';
    }


}
