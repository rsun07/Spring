package com.xiaoming.java_framwork.spring_basic.aop_basic.xml_aop;

import com.xiaoming.java_framwork.spring_basic.aop_basic.xml_aop.CalculatorAopImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopAroundAdviceTest {
    private ApplicationContext ctx;
    private CalculatorAopImpl calculator;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("beanAop.xml");
        calculator = (CalculatorAopImpl) ctx.getBean("aopCalculator");
    }

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
