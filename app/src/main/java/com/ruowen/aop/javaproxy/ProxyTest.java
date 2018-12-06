package com.ruowen.aop.javaproxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    private static final String TAG = "zhengbin ProxyTest";

    public void testProxy() {
        Log.d(TAG, "zhengbin testProxy");
        //创建一个实例对象，这个对象是被代理的对象
        Person zhangsan = new Worker("张三");
        //创建一个与代理对象相关联的InvocationHandler
        InvocationHandler handler = new MyInvocationHandler<>(zhangsan);
        //创建一个代理对象stuProxy来代理zhangsan，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, handler);
        stuProxy.think();
    }
}
