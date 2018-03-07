package com.xiaoming.spring.basic_injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionInjectionTest {
    @Test
    public void testInjectList() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("constructorInjectionContext.xml");

        Person jerry = (Person) ctx.getBean("Jerry");
        System.out.println(jerry.toString());
    }
}
