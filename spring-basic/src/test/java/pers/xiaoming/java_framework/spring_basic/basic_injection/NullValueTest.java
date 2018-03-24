package pers.xiaoming.java_framework.spring_basic.basic_injection;

import pers.xiaoming.java_framework.spring_basic.hello_world.HelloWorld;
import pers.xiaoming.java_framwork.spring_basic.hello_world.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaoming.java_framwork.spring_basic.hello_world.HelloWorld;

public class NullValueTest {
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("helloWorldContext.xml");

        HelloWorld helloWorldNull = (HelloWorld) ctx.getBean("helloWorldNull");
        System.out.println(helloWorldNull.getMessage());
    }
}
