package pers.xiaoming.java_spring.resource.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

public class Student {
    @Value("John")
    private String name;

    @Value("23")
    private int age;

    // if no name specified, inject by class
    @Resource
    private School school;
}
