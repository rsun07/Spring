package pers.xiaoming.java_spring.resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.xiaoming.java_spring.resource.entity.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class RunwithSpringJUnit4ClassRunner {

    @Autowired
    @Qualifier("student")
    private Student student;

    @Test
    public void test() {
        System.out.println(student);
    }
}
