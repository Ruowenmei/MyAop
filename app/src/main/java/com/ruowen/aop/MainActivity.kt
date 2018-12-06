package com.ruowen.aop

import android.Manifest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.ruowen.aop.annotation.MPermission
import com.ruowen.aop.aspectj.Animal
import com.ruowen.aop.javaproxy.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        javaProxy()
        init()
    }

    @MPermission(value = Manifest.permission.CAMERA)
    private fun init() {
        var animal = Animal()
        var result = animal.eat("banana")
        Log.d("zhengbin", "result=" + result)

        animal.weight = 40

        var weight = animal.myWeight
        Log.d("zhengbin", "weight=" + weight)

        animal.hurt()
    }

    private fun javaProxy(){
        var test = ProxyTest()
        test.testProxy()
    }
}
