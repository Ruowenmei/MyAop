package com.ruowen.aop.aspectj;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class HandlerAspect {
    private static final String TAG = "zhengbin HandlerAspect";

    /**
     * handler
     * 不支持@After、@Around
     */
    @Before("handler(java.lang.ArithmeticException)")
    public void handler() {
        Log.e(TAG, "handler");
    }

    /**\
     * @AfterThrowing 处理Java中未被catch的异常
     * @param joinPoint
     * @param t
     */
    @AfterThrowing(pointcut = "execution(int com.ruowen.aop.aspectj.*.*(..))", throwing = "t1")
    public void anyFuncThrows(JoinPoint joinPoint, Throwable t1) {
        Log.e(TAG, "hurtThrows: ", t1);
    }
}
