package com.xiaoming.spring.basic_injection;

import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InternalBeanTest {

    private static final ApplicationContext CTX = new ClassPathXmlApplicationContext("constructorInjectionContext.xml");

    @Test
    public void test() {
        Car carInternalEngine = (Car) CTX.getBean("carInternalEngine");
        System.out.println(carInternalEngine.toString());

        System.out.println(carInternalEngine.getEngine());
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testGetInternalBean() {
        Engine internalEngine = (Engine) CTX.getBean("internalEngine");
    }
}
