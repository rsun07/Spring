package pers.xiaoming.java_spring.di.basic_injection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionInjectionTest {
    private ApplicationContext ctx;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("basicInjectionContext.xml");
    }

    @Test
    public void testInjectList() {
        Person jerry = (Person) ctx.getBean("Jerry");
        System.out.println(jerry.toString());
    }

    @Test
    public void testInjectMap() {
        Person peter = (Person) ctx.getBean("Peter");
        System.out.println(peter.toString());
    }

    @Test
    public void testUtilMapInjection() {
        Person peter = (Person) ctx.getBean("Jane");
        System.out.println(peter.toString());
    }
}
