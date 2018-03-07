package com.xiaoming.spring.basic_injection;

import com.xiaoming.spring.hello_world.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NullValueTest {
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("helloWorldContext.xml");

        HelloWorld helloWorldNull = (HelloWorld) ctx.getBean("helloWorldNull");
        System.out.println(helloWorldNull.getMessage());
    }
}
