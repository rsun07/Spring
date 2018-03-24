package pers.xiaoming.java_framework.spring_basic.aop_basic.annotation_aop;

import pers.xiaoming.java_framework.spring_basic.aop_basic.traditional_impl.Calculator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopBasicAdvicesTest {
    private ApplicationContext ctx;
    private Calculator calculator;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        calculator = (Calculator) ctx.getBean("aopCalculator");
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
