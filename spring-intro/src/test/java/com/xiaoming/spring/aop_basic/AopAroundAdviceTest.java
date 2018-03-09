package com.xiaoming.spring.aop_basic;

import com.xiaoming.spring.aop_basic.spring_aop.AppConfig;
import com.xiaoming.spring.aop_basic.spring_aop.CalculatorAopImpl;
import com.xiaoming.spring.aop_basic.traditional_impl.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopAroundAdviceTest {
    private final ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    private final CalculatorAopImpl calculator = (CalculatorAopImpl) ctx.getBean("aopCalculatorImpl");

    @Test
    public void testNoException() {
        calculator.divide(8,3);
    }

    @Test(expected = RuntimeException.class)
    public void testException() {
        // @Begin advice will run
        // @After advice will run even though exception throw
        // @AfterReturning advice won't run because the exception
        // @AfterThrowing advice will run obviously
        calculator.divide(1,0);
    }
}
