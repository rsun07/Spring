package com.xiaoming.spring.aop_basic.xml_aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopAroundAdviceTest {
    private final ApplicationContext ctx = new ClassPathXmlApplicationContext("beanAop.xml");
    private final CalculatorAopImpl calculator = (CalculatorAopImpl) ctx.getBean("aopCalculator");

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
