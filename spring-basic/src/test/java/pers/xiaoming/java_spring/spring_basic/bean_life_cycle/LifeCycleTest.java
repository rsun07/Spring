package pers.xiaoming.java_spring.spring_basic.bean_life_cycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beanLifeCycle.xml");
        System.out.println(ctx.getBean("myBean").toString());
        ctx.destroy();
    }
}
