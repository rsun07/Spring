package pers.xiaoming.java_spring.spring_ioc.bean_life_cycle;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class LifeCycleTest {
    /*
        Running Dynamic code block, my bean name is : null
        Constructing...
        Setting name to <My Bean!>
        My Bean post process before init method
        Init..., my bean name is : My Bean!
        My Bean post process after init method
        Setting name to <Post Process Reset Name>
     */
    @Test
    public void testInitContainerUseApplicationContext() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanLifeCycle.xml");
    }

    // Won't create any Bean
    @Test
    public void testInitContainerUserBeanFactory() {
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beanLifeCycle.xml"));
    }

    /*
        Running Dynamic code block, my bean name is : null
        Constructing...
        Setting name to <My Bean!>
        My Bean post process before init method
        Init..., my bean name is : My Bean!
        My Bean post process after init method
        Setting name to <Post Process Reset Name>
        Apr 24, 2018 8:35:51 PM org.springframework.context.support.ClassPathXmlApplicationContext doClose
        INFO: Closing org.springframework.context.support.ClassPathXmlApplicationContext@5cbc508c: startup date [Tue Apr 24 20:35:51 PDT 2018]; root of context hierarchy
        LifecycleBean{name='Post Process Reset Name'}

        Destroying...
     */
    @Test
    public void testGetBean() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beanLifeCycle.xml");
        System.out.println(ctx.getBean("myBean").toString());
        ctx.destroy();
    }
}
