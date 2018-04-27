package pers.xiaoming.java_spring.annotation_aop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        Assert.assertEquals(10, calculator.add(2, 8));
        System.out.println();
        Assert.assertEquals(5, calculator.sub(8, 3));
        System.out.println();
        Assert.assertEquals(24, calculator.mul(8,3));
        System.out.println();
        Assert.assertEquals(2, calculator.div(8,3));
        System.out.println();
    }

    @Test(expected = ArithmeticException.class)
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
        }    }
}
