package com.ruowen.aop.aspectj;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class FieldAspect {
    private static final String TAG = "zhengbin FieldAspect";

    @Pointcut("get(int com.ruowen.aop.aspectj.Animal.weight)")
    public void getWeight(){
    }

    /**
     * !withincode(com.ruowen.aop.aspectj.Animal.new(..)) 不改变构造函数中的赋值
     */
    @Pointcut("set(int com.ruowen.aop.aspectj.Animal.weight) && !withincode(com.ruowen.aop.aspectj.Animal.new(..))")
    public void setWeight(){
    }

    @Around("getWeight()")
    public int aroundFieldGet(ProceedingJoinPoint joinPoint) throws Throwable {
        // 执行原代码
        Object obj = joinPoint.proceed();
        int age = Integer.parseInt(obj.toString());
        Log.e(TAG, "weight: " + age);
        return 100;
    }

    @Around("setWeight()")
    public void aroundFieldSet(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e(TAG, "around set->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
        //joinPoint.proceed();
    }
}
