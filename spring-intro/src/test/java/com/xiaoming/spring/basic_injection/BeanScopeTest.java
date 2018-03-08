package com.xiaoming.spring.basic_injection;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeTest {
    @Test
    public void testSingletonBean() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("basicInjectionContext.xml");

        Engine singletonEngine1 = (Engine) ctx.getBean("singletonEngine");
        Engine singletonEngine2 = (Engine) ctx.getBean("singletonEngine");

        Assert.assertEquals(singletonEngine1, singletonEngine2);
        Assert.assertTrue(singletonEngine1 == singletonEngine2);
    }

    @Test
    public void testPrototypeBean() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("basicInjectionContext.xml");

        Engine singletonEngine1 = (Engine) ctx.getBean("prototypeEngine");
        Engine singletonEngine2 = (Engine) ctx.getBean("prototypeEngine");

        Assert.assertEquals(singletonEngine1, singletonEngine2);
        Assert.assertFalse(singletonEngine1 == singletonEngine2);
    }
}
