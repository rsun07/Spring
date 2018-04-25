package pers.xiaoming.java_spring.di.basic_injection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeTest {
    private ApplicationContext ctx;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("basicInjectionContext.xml");
    }

    @Test
    public void testSingletonBean() {
        Engine singletonEngine1 = (Engine) ctx.getBean("singletonEngine");
        Engine singletonEngine2 = (Engine) ctx.getBean("singletonEngine");

        Assert.assertEquals(singletonEngine1, singletonEngine2);
        Assert.assertTrue(singletonEngine1 == singletonEngine2);
    }

    @Test
    public void testPrototypeBean() {
        Engine singletonEngine1 = (Engine) ctx.getBean("prototypeEngine");
        Engine singletonEngine2 = (Engine) ctx.getBean("prototypeEngine");

        Assert.assertEquals(singletonEngine1, singletonEngine2);
        Assert.assertFalse(singletonEngine1 == singletonEngine2);
    }
}
