package pers.xiaoming.java_spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaoming.java_spring.di_xml_entity.Address;
import pers.xiaoming.java_spring.di_xml_entity.School;
import pers.xiaoming.java_spring.di_xml_entity.Student;

public class AutowireTest {
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("autowireContext.xml");
        Student actual = (Student) ac.getBean("student");
        Student expect = getExpectStudent();

        Assert.assertEquals(actual, expect);
    }

    private Student getExpectStudent() {
        Address address = new Address(8888, "CA DR", 12345);

        School school = new School("MySchool");
        school.setAddress(address);

        Student student = new Student();
        student.setName("John");
        student.setAge(23);
        student.setSchool(school);
        return student;
    }
}
