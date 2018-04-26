package pers.xiaoming.java_spring.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Executing MyMethodInterceptor before invoking target method");

        Object result = methodInvocation.proceed();

        System.out.println("Executing MyMethodInterceptor after invoking target method, result is : " + result);

        return result;
    }
}
