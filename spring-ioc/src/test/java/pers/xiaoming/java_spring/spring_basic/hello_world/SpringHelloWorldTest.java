package pers.xiaoming.java_spring.spring_basic.hello_world;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class SpringHelloWorldTest {

    @Test
    public void testClassPathXmlApplicationContext() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("helloWorldContext.xml");
        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
    }

    @Test
    public void testFileSystemXmlApplicationContext() {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("/src/main/resources/helloWorldContext.xml");
        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
    }

    @Test
    public void testBeanFactory() {
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("helloWorldContext.xml"));
        HelloWorld helloWorld = factory.getBean(HelloWorld.class);
    }

    @Test(expected = NoUniqueBeanDefinitionException.class)
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("duplicateBeanApplicationContext.xml");

        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
    }

}
