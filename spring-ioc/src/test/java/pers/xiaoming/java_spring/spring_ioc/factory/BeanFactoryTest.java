package pers.xiaoming.java_spring.spring_ioc.factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaoming.java_spring.spring_ioc.entity.MyBean;

public class BeanFactoryTest {
    private final ApplicationContext ac = new ClassPathXmlApplicationContext("beanFactoryContext.xml");

    @Test
    public void testDynamicBeanFactory() {
        MyBean myBean = (MyBean) ac.getBean("myDynamicBean");
    }

    @Test
    public void testStaticBeanFactory() {
        MyBean myBean = (MyBean) ac.getBean("myStaticBean");
    }
}
