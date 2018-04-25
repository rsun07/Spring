package pers.xiaoming.java_spring.spring_basic.bean_life_cycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    public void testOnlyInitContainer() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beanLifeCycle.xml");
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
        MyBean{name='Post Process Reset Name'}

        Destroying...
     */
    @Test
    public void testGetBean() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beanLifeCycle.xml");
        System.out.println(ctx.getBean("myBean").toString());
        ctx.destroy();
    }
}
