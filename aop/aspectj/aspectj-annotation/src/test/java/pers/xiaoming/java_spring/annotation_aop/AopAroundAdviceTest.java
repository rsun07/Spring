package pers.xiaoming.java_spring.annotation_aop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopAroundAdviceTest {
    private ApplicationContext ac;
    private CalculatorAopImpl calculator;

    @Before
    public void setUp() {
        ac = new AnnotationConfigApplicationContext(AppConfig.class);
        calculator = (CalculatorAopImpl) ac.getBean("aopCalculatorImpl");
    }

    @Test
    public void testNoException() {
        // only divide() method triggers around aspect
        Assert.assertEquals(2, calculator.divide(8,3), 0.0001);
    }

    @Test(expected = RuntimeException.class)
    public void testException() {
        // @Begin advice will run
        // @After advice will run even though exception throw
        // @AfterReturning advice won't run because the exception
        // @AfterThrowing advice will run obviously
        try {
            calculator.divide(1, 0);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
