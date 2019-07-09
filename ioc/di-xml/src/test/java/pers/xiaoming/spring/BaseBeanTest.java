package pers.xiaoming.spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseBeanTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("baseBeanContext.xml");

    @Test
    public void testObjectBaseBean() {
        School objectSchool = new School("ObjectSchool");

        Student Marry = new Student();
        Marry.setName("Marry");
        Marry.setAge(22);
        Marry.setSchool(objectSchool);

        Student Jane = new Student();
        Jane.setName("Jane");
        Jane.setAge(20);
        Jane.setSchool(objectSchool);

        Student actualMarry = (Student) ac.getBean("Marry");
        Student actualJane = (Student) ac.getBean("Jane");

        Assert.assertEquals(Marry, actualMarry);
        Assert.assertEquals(Jane, actualJane);
    }

    @Test
    public void testBaseBean() {
        School mySchool = new School("MySchool");
        Student John = new Student();
        John.setName("John");
        John.setAge(23);
        John.setSchool(mySchool);

        Student Mike = new Student();
        Mike.setName("Mike");
        Mike.setAge(21);
        Mike.setSchool(mySchool);

        Student actualJohn = (Student) ac.getBean("John");
        Student actualMike = (Student) ac.getBean("Mike");

        Assert.assertEquals(John, actualJohn);
        Assert.assertEquals(Mike, actualMike);
    }
}
