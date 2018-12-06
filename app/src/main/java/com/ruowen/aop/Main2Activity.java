package com.ruowen.aop;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ruowen.aop.annotation.MPermission;
import com.ruowen.aop.aspectj.Animal;
import com.ruowen.aop.javaproxy.ProxyTest;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        javaProxy();

        init();
    }

    @MPermission(value = Manifest.permission.CAMERA)
    private void init() {
        Animal animal = new Animal();
        String result = animal.eat("banana");
        Log.d("zhengbin", "result=" + result);

        animal.setWeight(40);

        int weight = animal.getWeight();
        Log.d("zhengbin", "weight=" + weight);

        animal.hurt();
    }

    private void javaProxy(){
        new ProxyTest().testProxy();
    }
}
