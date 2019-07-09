package pers.xiaoming.spring.advice;

import org.springframework.aop.ThrowsAdvice;

public class MyThrowsAdvice implements ThrowsAdvice {

    // Interface ThrowsAdvice is a marker/tagged interface
    // @Override
    public void afterThrowing(Exception ex) {
        System.out.println("Executing My Throws Advice");
    }
}
