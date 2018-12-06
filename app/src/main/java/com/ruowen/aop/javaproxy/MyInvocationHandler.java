package com.ruowen.aop.javaproxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler<T> implements InvocationHandler {
    private static final String TAG = "zhengbin MyInvocationHandler";

    private T target;

    public MyInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Log.d("zhengbin", TAG + "代理执行" + method.getName() + "方法");

        //代理过程中插入监测方法,计算该方法耗时
        MonitorUtils.start();
        Object result = method.invoke(target, args);
        MonitorUtils.finish(method.getName());
        return result;
    }
}
