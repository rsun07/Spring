package pers.xiaoming.java_spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.xiaoming.java_spring.annotation_aop.AppConfig;
import pers.xiaoming.java_spring.annotation_aop.Calculator;

public class AopBasicAdvicesTest {
    private ApplicationContext ac;
    private Calculator calculator;

    @Before
    public void setUp() {
        ac = new AnnotationConfigApplicationContext(AppConfig.class);
        calculator = (Calculator) ac.getBean("aopCalculatorImpl");
    }

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
