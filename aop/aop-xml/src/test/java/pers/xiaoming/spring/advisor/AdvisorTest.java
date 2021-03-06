package pers.xiaoming.spring.advisor;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaoming.spring.entity.AOPTarget;
import pers.xiaoming.spring.TestUtils;

@Ignore("demo test")
public class AdvisorTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("advisorContext.xml");

    @Test
    public void testBeforeAdvisor() {
        AOPTarget target = (AOPTarget) ac.getBean("beforeAdvisorProxy");
        TestUtils.testTarget(target);
    }

    @Test
    public void testAfterAdvisor() {
        AOPTarget target = (AOPTarget) ac.getBean("afterAdvisorProxy");
        TestUtils.testTarget(target);
    }

    @Test
    public void testMethodInterceptorAdvisor() {
        AOPTarget target = (AOPTarget) ac.getBean("methodInterceptorAdvisorProxy");
        TestUtils.testTarget(target);
    }

    @Test
    public void testRegexAdvisor() {
        AOPTarget target = (AOPTarget) ac.getBean("regexAdvisorProxy");
        TestUtils.testTarget(target);
    }
}
