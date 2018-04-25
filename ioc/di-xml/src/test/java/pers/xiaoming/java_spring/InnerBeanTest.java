package pers.xiaoming.java_spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InnerBeanTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("innerBeanInjectionContext.xml");

    @Test
    public void testGetOuterBean() {
        Address address = new Address(8888, "CA DR", 12345);

        School expect = new School("MySchool");
        expect.setAddress(address);
        School actual = ac.getBean(School.class);
        Assert.assertEquals(expect, actual);
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void testGetInnerBean() {
        Address address = ac.getBean(Address.class);
    }
}
