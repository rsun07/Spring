package com.xiaoming.spring.hello_world;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create Spring IOC Container Object
        ApplicationContext ctx = new ClassPathXmlApplicationContext("helloWorldContext.xml");

        // Step 2: Get Bean instance from IOC container
        HelloWorld helloWorld1 = (HelloWorld) ctx.getBean("helloWorld1");
        System.out.println("Bean instance from IOC container: " + helloWorld1);

        // Step 3: Call Bean's method
        System.out.println("Bean message: " + helloWorld1.getMessage());

    }
}
