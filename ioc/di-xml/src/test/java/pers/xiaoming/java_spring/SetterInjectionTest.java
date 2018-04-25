package pers.xiaoming.java_spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaoming.java_spring.di_xml_entity.Student;

public class SetterInjectionTest {
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("setterInjectionContext.xml");
        Student actual = (Student) ac.getBean("student");

        Student expect = new Student();
        expect.setName("John");
        expect.setAge(23);

        Assert.assertEquals(actual, expect);
    }
}
