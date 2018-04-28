package pers.xiaoming.java_spring.xml_aop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaoming.java_spring.TestUtils;

public class AopBasicAdvicesTest {
    private static ApplicationContext ctx;
    private static CalculatorAopImpl calculator;

    @BeforeClass
    public static void setUp() {
        ctx = new ClassPathXmlApplicationContext("aspectjContext.xml");
        calculator = (CalculatorAopImpl) ctx.getBean("aopCalculator");

        /*
            Class name is : pers.xiaoming.java_spring.xml_aop.CalculatorAopImpl$$EnhancerBySpringCGLIB$$7cfcfc8a
            Super Class is : class pers.xiaoming.java_spring.xml_aop.CalculatorAopImpl
            Interfaces are : [interface org.springframework.aop.SpringProxy, interface org.springframework.aop.framework.Advised, interface org.springframework.cglib.proxy.Factory]
         */
        TestUtils.printClassInfo(calculator.getClass());
        System.out.println();
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
        calculator.div(1,0);
    }
}
