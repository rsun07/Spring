package com.xiaoming.spring.aop_basic.spring_aop;

import org.aspectj.lang.JoinPoint;
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

    @Before("execution(public double com.xiaoming.spring.aop_basic.spring_aop.CalculatorAopImpl.add(double, double))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("Running the " + methodName + " method begins with " + args);
    }
}
