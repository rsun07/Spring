package pers.xiaoming.java_spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaoming.java_spring.di_xml_entity.Address;

public class ConstructorInjectionTest {
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("constructorInjectionContext.xml");
        Address actual = (Address) ac.getBean("address");

        Address expect = new Address(8888, "CA DR", 12345);

        Assert.assertEquals(actual, expect);
    }
}
