package com.ruowen.aop.aspectj;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class StaticBlockAspect {
    private static final String TAG = "zhengbin StaticBlockAspect";

    @Pointcut("staticinitialization(com.ruowen.aop.aspectj.Animal)")
    public void staticBlock(){

    }

    /*@Before("staticBlock()")
    public void beforeStaticBlock(JoinPoint joinPoint) {
        Log.d(TAG, "beforeStaticBlock");
    }

    @After("staticBlock()")
    public void afterStaticBlock(JoinPoint joinPoint) {
        Log.d(TAG, "afterStaticBlock");
    }*/

    @Around("staticBlock()")
    public void aroundStaticBlock(JoinPoint joinPoint) {
        Log.d(TAG, "aroundStaticBlock");
    }
}
