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
public class ExecMethodAspect {
    private static final String TAG = "zhengbin ExecMethodAspect";

    @Pointcut("execution(* com.ruowen.aop.aspectj.Animal.eat(..))")
    public void execMethod() {
    }

    @Before("execMethod()")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        Log.e(TAG, "before->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
    }

    @After("execMethod()")
    public void afterMethodExecution(JoinPoint joinPoint) {
        Log.e(TAG, "after->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
    }

    /*@Around("execMethod()")
    public void aroundMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e(TAG, "around->1" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
        joinPoint.proceed();
        Log.e(TAG, "around->2" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
    }*/
}
