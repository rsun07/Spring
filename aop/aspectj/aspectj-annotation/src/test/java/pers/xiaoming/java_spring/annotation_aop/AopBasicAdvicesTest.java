package pers.xiaoming.java_spring.annotation_aop;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.xiaoming.java_spring.TestUtils;

public class AopBasicAdvicesTest {
    private static ApplicationContext ac;
    private static CalculatorAopImpl calculator;

    @BeforeClass
    public static void setUp() {
        ac = new AnnotationConfigApplicationContext(AppConfig.class);
        calculator = (CalculatorAopImpl) ac.getBean("aopCalculatorImpl");

        /*
            Class name is : pers.xiaoming.java_spring.annotation_aop.CalculatorAopImpl$$EnhancerBySpringCGLIB$$2904fd94
            Super Class is : class pers.xiaoming.java_spring.annotation_aop.CalculatorAopImpl
            Interfaces are : [interface org.springframework.aop.scope.ScopedObject, interface java.io.Serializable, interface org.springframework.aop.framework.AopInfrastructureBean, interface org.springframework.aop.SpringProxy, interface org.springframework.aop.framework.Advised, interface org.springframework.cglib.proxy.Factory]
         */
        TestUtils.printClassInfo(calculator.getClass());
        System.out.println();
    }

    @Test
    public void testBasic() {
        Assert.assertEquals(10, calculator.add(2, 8));
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
        }
    }
}
