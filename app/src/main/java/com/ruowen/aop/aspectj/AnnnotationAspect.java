package com.ruowen.aop.aspectj;

import android.Manifest;
import android.app.Activity;
import android.util.Log;

import com.ruowen.aop.MainActivity;
import com.ruowen.aop.annotation.MPermission;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AnnnotationAspect {

    private static final String TAG = "zhengbin AnnotationAspect";

    @Around("execution(@com.ruowen.aop.annotation.MPermission * *(..)) && @annotation(permisson)")
    public void checkPermisson(final ProceedingJoinPoint joinPoint, MPermission permisson) throws Throwable {
        // 权限
        String permissonStr = permisson.value();
        Log.v(TAG, "execAnnotation checkPermisson permissonStr="+permissonStr);
        // 正常需要使用维护的栈顶Activity作为上下文，这里为了演示需要
        Activity mainActivity = (Activity) joinPoint.getThis();          // 权限申请
        joinPoint.proceed();
        /*Utils.requestPermisson(mainActivity, Manifest.permission.CAMERA).
                    throwable.printStackTrace();callback(new Callback() {
            public void onGranted() {
                try {
                    // 继续执行原方法
                    joinPoint.proceed();
                } catch (Throwable throwable) {
                }
            }

            public void onDenied() {
            }
        });*/
    }
}
