package pers.xiaoming.java_spring.jdk_dynamic_proxy;

import pers.xiaoming.java_spring.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class CalculatorLoggingProxy {

    // the target class to be proxy
    private Calculator target;

    public CalculatorLoggingProxy(Calculator target) {
        this.target = target;
    }

    public Calculator getLoggingProxy() {
        Calculator proxy = null;

        ClassLoader classLoader = target.getClass().getClassLoader();

        Class[] interfaces = new Class[]{Calculator.class};


        InvocationHandler invocationHandler = new LogInvocationHandler(target);

        proxy = (Calculator) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return proxy;
    }
}
