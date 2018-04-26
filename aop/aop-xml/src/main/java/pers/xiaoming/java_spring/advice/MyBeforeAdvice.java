package pers.xiaoming.java_spring.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyBeforeAdvice implements MethodBeforeAdvice {
    /**
     *
     * @param method the method going to be enhanced
     * @param args the params needed in the method
     * @param target target object
     * @throws Throwable
     */

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Executing My Before Advice");
    }
}
