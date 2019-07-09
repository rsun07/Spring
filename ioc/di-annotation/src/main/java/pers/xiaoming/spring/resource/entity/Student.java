package pers.xiaoming.spring.resource.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

// no constructor needed
// no setter function needed
@Component("student")
public class Student {
    @Value("John")
    private String name;

    @Value("23")
    private int age;

    // if no name specified, inject by class
    @Resource
    private School school;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
