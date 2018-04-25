package pers.xiaoming.java_spring.ioc_basic.action_scope;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaoming.java_spring.ioc_basic.entity.MyBean;

public class ActionScopeTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("actionScopeContext.xml");

    @Test
    public void testSingleton() {
        MyBean singleton1 = (MyBean) ac.getBean("singleton");
        MyBean singleton2 = (MyBean) ac.getBean("singleton");
        Assert.assertSame(singleton1, singleton2);
    }

    @Test
    public void testPrototype() {
        MyBean prototype1 = (MyBean) ac.getBean("prototype");
        MyBean prototype2 = (MyBean) ac.getBean("prototype");
        Assert.assertNotSame(prototype1, prototype2);
    }
}
