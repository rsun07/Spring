package com.xiaoming.spring.aop_basic.spring_aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// initialize the class as an Aspect, inject to IOC container
@Aspect
@EnableAspectJAutoProxy
@Component
public class LoggingAspect {

    /* using star to indicate any method
        could also be "execution(* com.xiaoming.spring.aop_basic.spring_aop.CalculatorAopImpl.*(int, int))"
        means any access modifier and return type

        "execution(* com.xiaoming.spring.aop_basic.spring_aop.*.*(int, int))"
        means all the Classes in this package and all the methods of those classes whose parameters are two ints
    */
    @Before("execution(public int com.xiaoming.spring.aop_basic.spring_aop.CalculatorAopImpl.*(int, int))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("Running the <" + methodName + "> method begins with " + args);
    }

    /*
      Even tough exception throws, @After will still execute.
      But After advice cannot get the return value of the function.
     */
    @After("execution(public int com.xiaoming.spring.aop_basic.spring_aop.CalculatorAopImpl.*(int, int))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("<" + methodName + "> method ends. Running even though exception was threw ");
    }
}
