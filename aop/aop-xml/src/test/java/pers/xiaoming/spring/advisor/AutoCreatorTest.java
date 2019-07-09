package pers.xiaoming.spring.advisor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaoming.spring.entity.AOPTarget;
import pers.xiaoming.spring.TestUtils;

public class AutoCreatorTest {
    @Test
    public void testDefaultAutoAdvisorProxyCreator() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("defaultAdvisorAutoCreatorContext.xml");

        // get by target bean id directly rather than proxy bean id
        AOPTarget target = (AOPTarget) ac.getBean("target");
        TestUtils.testTarget(target);
    }

    @Test
    public void testBeanNameAutoAdvisorProxyCreator() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beanNameAutoCreatorContext.xml");

        AOPTarget target = (AOPTarget) ac.getBean("target");
        TestUtils.testTarget(target);

        AOPTarget targetCopy = (AOPTarget) ac.getBean("targetCopy");
        TestUtils.testTarget(targetCopy);
    }
}
