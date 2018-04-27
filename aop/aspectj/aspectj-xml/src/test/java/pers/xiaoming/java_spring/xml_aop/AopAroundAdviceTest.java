package pers.xiaoming.java_spring.xml_aop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopAroundAdviceTest {
    private ApplicationContext ctx;
    private CalculatorAopImpl calculator;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("aspectjContext.xml");
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
        try {
            calculator.div(1, 0);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
