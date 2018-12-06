package com.ruowen.aop.aspectj;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CallMethodAspect {
    private static final String TAG = "zhengbin CallMethodAspect";
    private long startTime = 0;

    @Pointcut("call(* com.ruowen.aop.aspectj.Animal.eat(String))")
    public void callMethod() {
    }

    /*@Before("callMethod()")
    public void beforeMethodCall(JoinPoint joinPoint) {
        startTime = System.currentTimeMillis();
        Log.e(TAG, "before->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName() + ", now=" + startTime);
    }

    @After("callMethod()")
    public void afterMethodCall(JoinPoint joinPoint) {
        long now = System.currentTimeMillis();
        long cost = now - startTime;
        Log.e(TAG, "after->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName() + ", now=" + now + ", cost=" + cost);
    }*/

    /**
     * 不能和Before、After一起使用
     * @param joinPoint
     * @throws Throwable
     *//*
    @Around("callMethod()")
    public String aroundMethodCall(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e(TAG, "around->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());

        // 执行原代码
        return joinPoint.proceed().toString() + "bbbbb" + (joinPoint.getArgs())[0].toString();
    }*/
}