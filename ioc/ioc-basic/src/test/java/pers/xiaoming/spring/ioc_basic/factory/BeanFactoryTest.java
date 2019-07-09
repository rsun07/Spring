package pers.xiaoming.spring.ioc_basic.factory;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaoming.spring.ioc_basic.entity.MyBean;

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
