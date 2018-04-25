package pers.xiaoming.java_spring.di.basic_injection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InternalBeanTest {

    private ApplicationContext ctx;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("basicInjectionContext.xml");
    }

    @Test
    public void test() {
        Car carInternalEngine = (Car) ctx.getBean("carInternalEngine");
        System.out.println(carInternalEngine.toString());

        System.out.println(carInternalEngine.getEngine());
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testGetInternalBean() {
        Engine internalEngine = (Engine) ctx.getBean("internalEngine");
    }
}
