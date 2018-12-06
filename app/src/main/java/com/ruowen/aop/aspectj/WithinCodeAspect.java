package com.ruowen.aop.aspectj;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class WithinCodeAspect {
    private static final String TAG = "zhengbin WithinCodeAspect";

    /*@Pointcut("withincode(* com.ruowen.aop.aspectj.Animal.*(..))")
    public void withinCode() {

    }

    @Before("withinCode()")
    public void beforeWithinCode(JoinPoint joinPoint) {
        Log.d("zhengbin", TAG + "before withincode Jpoint=" + joinPoint.getSignature().getName());
    }*/
}
