package com.xiaoming.spring.aop_basic.xml_aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopBasicAdvicesTest {
    private final ApplicationContext ctx = new ClassPathXmlApplicationContext("beanAop.xml");
    private final CalculatorAopImpl calculator = (CalculatorAopImpl) ctx.getBean("aopCalculator");

    @Test
    public void testBasic() {
        calculator.add(2, 8);
        calculator.sub(8, 3);
        calculator.mul(8,3);
        calculator.div(8,3);
    }

    @Test(expected = ArithmeticException.class)
    public void testException() {
        // @Begin advice will run
        // @After advice will run even though exception throw
        // @AfterReturning advice won't run because the exception
        // @AfterThrowing advice will run obviously
        calculator.div(1,0);
    }
}
