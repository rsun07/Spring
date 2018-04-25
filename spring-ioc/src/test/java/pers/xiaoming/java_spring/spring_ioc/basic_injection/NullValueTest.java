package pers.xiaoming.java_spring.spring_ioc.basic_injection;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaoming.java_spring.spring_ioc.hello_world.HelloWorld;

// TODO:
@Ignore("TODO: ")
public class NullValueTest {
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("helloWorldContext.xml");

        HelloWorld helloWorldNull = (HelloWorld) ctx.getBean("helloWorldNull");
        System.out.println(helloWorldNull.getMessage());
    }
}
