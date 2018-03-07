package com.xiaoming.spring.basic_injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionInjectionTest {
    @Test
    public void testInjectList() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("basicInjectionContext.xml");

        Person jerry = (Person) ctx.getBean("Jerry");
        System.out.println(jerry.toString());
    }

    @Test
    public void testInjectMap() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("basicInjectionContext.xml");

        Person peter = (Person) ctx.getBean("Peter");
        System.out.println(peter.toString());
    }

    @Test
    public void testUtilMapInjection() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("basicInjectionContext.xml");

        Person peter = (Person) ctx.getBean("Jane");
        System.out.println(peter.toString());
    }
}
