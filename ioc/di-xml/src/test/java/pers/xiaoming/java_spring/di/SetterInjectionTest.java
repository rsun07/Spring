package pers.xiaoming.java_spring.di;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaoming.java_spring.di.entity.Address;
import pers.xiaoming.java_spring.di.entity.School;
import pers.xiaoming.java_spring.di.entity.Student;

public class SetterInjectionTest {
    private static Student expect;

    @BeforeClass
    public static void setup() {
        Address address = new Address(3690, "CA ROAD", 10000);
        School school = new School("MySchool", address);
        expect = new Student("John", 23, school);
    }

    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student actual = (Student) ac.getBean("student");
        Assert.assertEquals(expect, actual);
    }
}
