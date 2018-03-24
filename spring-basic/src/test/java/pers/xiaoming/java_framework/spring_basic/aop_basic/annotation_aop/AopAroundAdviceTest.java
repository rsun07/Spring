package pers.xiaoming.java_framework.spring_basic.aop_basic.annotation_aop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopAroundAdviceTest {
    private ApplicationContext ctx;
    private CalculatorAopImpl calculator;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        calculator = (CalculatorAopImpl) ctx.getBean("aopCalculatorImpl");
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
