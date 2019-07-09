package pers.xiaoming.spring.resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pers.xiaoming.spring.resource.entity.Student;

public class ResourceTest {
    @Test
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
    }
}
