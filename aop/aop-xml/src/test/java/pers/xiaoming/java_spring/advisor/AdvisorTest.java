package pers.xiaoming.java_spring.advisor;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaoming.java_spring.entity.AOPTarget;

@Ignore("demo test")
public class AdvisorTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("advisorContext.xml");

    @Test
    public void testBeforeAdvisor() {
        AOPTarget target = (AOPTarget) ac.getBean("beforeAdvisorProxy");
        testTarget(target);
    }

    @Test
    public void testAfterAdvisor() {
        AOPTarget target = (AOPTarget) ac.getBean("afterAdvisorProxy");
        testTarget(target);
    }

    @Test
    public void testMethodInterceptorAdvisor() {
        AOPTarget target = (AOPTarget) ac.getBean("methodInterceptorAdvisorProxy");
        testTarget(target);
    }

    @Test
    public void testRegexAdvisor() {
        AOPTarget target = (AOPTarget) ac.getBean("regexAdvisorProxy");
        testTarget(target);
    }

    @Test
    public void testAutoAdvisorProxyCreator() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("advisorAutoCreatorContext.xml");

        // get by target bean id directly rather than proxy bean id
        AOPTarget target = (AOPTarget) ac.getBean("target");
        testTarget(target);

    }

    private void testTarget(AOPTarget target) {
        target.print();
        System.out.println();
        target.toUppercase("Abc");
        System.out.println();
        target.toLowercase("Abc");
    }
}
