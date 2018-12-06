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
public class ExecContructorAspect {
    private static final String TAG = "zhengbin ExecContructorAspect";

    @Pointcut("execution(com.ruowen.aop.aspectj.Animal.new(..))")
    public void execConstructor() {
    }

    /*@Before("execConstructor()")
    public void beforeConstructorExecution(JoinPoint joinPoint) {
        Log.e(TAG, "before->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
    }

    @After("execConstructor()")
    public void afterConstructorExecution(JoinPoint joinPoint) {
        Log.e(TAG, "after->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
    }*/

    @Around("execConstructor()")
    public void aroundConstructorExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e(TAG, "around->1" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
        joinPoint.proceed();
        Log.e(TAG, "around->2" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
    }
}
