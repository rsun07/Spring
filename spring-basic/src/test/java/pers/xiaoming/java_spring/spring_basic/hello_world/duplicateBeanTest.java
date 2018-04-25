package pers.xiaoming.java_spring.spring_basic.hello_world;

import org.junit.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class duplicateBeanTest {
    @Test(expected = NoUniqueBeanDefinitionException.class)
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("helloWorldContext.xml");

        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
    }

}
