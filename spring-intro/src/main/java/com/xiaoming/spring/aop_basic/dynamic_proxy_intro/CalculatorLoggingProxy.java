package com.xiaoming.spring.aop_basic.dynamic_proxy_intro;

import com.xiaoming.spring.aop_basic.traditional_impl.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

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

        /**
         *
         * @proxy the currently proxy instance, in normal cases, it should not be used within the invoke method
         * otherwise it may cause recursive invoke.
         * @method the current method invoked from the target proxy instance
         * @args the parameters passed when invoking the method
         *
         */
        InvocationHandler invocationHandler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                System.out.println("Running the " + methodName + " method begins with " + Arrays.asList(args));
                Object result = method.invoke(target, args);
                System.out.println("Running the " + methodName + " method ends with " + result);
                return result;
            }
        };

        proxy = (Calculator) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return proxy;
    }
}
