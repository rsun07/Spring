package pers.xiaoming.spring.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class MyAfterReturningAdvice implements AfterReturningAdvice {

    /**
     *
     * @param returnValue return value of the delegated method
     * @param method the method going to be enhanced
     * @param args the params needed in the method
     * @param target target object
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Executing After Returning Advice, return value is : " + returnValue);
    }
}
