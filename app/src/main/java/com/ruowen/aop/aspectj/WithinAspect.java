package com.ruowen.aop.aspectj;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class WithinAspect {
    private static final String TAG = "zhengbin WithinAspect";

    @Before("within(com.ruowen.aop.aspectj.Animal)")
    public void beforeWithin(JoinPoint joinPoint) {
        Log.d(TAG, "before within Jpoint=" + joinPoint.getSignature().getName());
    }
}
