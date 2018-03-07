package com.xiaoming.spring.hello_world;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create Spring IOC Container Object
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
