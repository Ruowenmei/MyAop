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
public class CallConstructorAspect {

    private static final String TAG = "zhengbin CallConstructor";

    @Pointcut("call(com.ruowen.aop.aspectj.Animal.new(..))")
    public void callConstructor() {
    }

    @Before("callConstructor()")
    public void beforeCallConstructor(JoinPoint joinPoint) {
        Log.d(TAG, "before->" + joinPoint.getThis().toString() + "#" + joinPoint.getSignature().getName());
    }

    @After("callConstructor()")
    public void afterCallConstructor(JoinPoint joinPoint) {
        Log.d(TAG, "after->" + joinPoint.getThis().toString() + "#" + joinPoint.getSignature().getName());
    }

    /*@Around("callConstructor()")
    public Animal aroundCallConstructor(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.d(TAG, "around->" + joinPoint.getThis().toString() + "#" + joinPoint.getSignature().getName());
        return (Animal) joinPoint.proceed();//new Animal();这里直接new 会出现死循环，暂时不清楚原因
    }*/
}
