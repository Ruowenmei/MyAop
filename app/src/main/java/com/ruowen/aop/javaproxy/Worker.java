package com.ruowen.aop.javaproxy;

import android.util.Log;

public class Worker implements Person {

    private static final String TAG = "zhengbin Worker";
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void think() {
        Log.d(TAG, name + " do work better");
    }
}
