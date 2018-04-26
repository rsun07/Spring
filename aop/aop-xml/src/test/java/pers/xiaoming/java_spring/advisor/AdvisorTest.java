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
        target.print();
        System.out.println();
        target.toLowercase("Abc");
    }

    @Test
    public void testAfterAdvisor() {
        AOPTarget target = (AOPTarget) ac.getBean("afterAdvisorProxy");
        target.print();
        System.out.println();
        target.toUppercase("Abc");
        System.out.println();
        target.toLowercase("Abc");
    }

    @Test
    public void testMethodInterceptorAdvisor() {
        AOPTarget target = (AOPTarget) ac.getBean("methodInterceptorAdvisorProxy");
        target.print();
        System.out.println();
        target.toUppercase("Abc");
        System.out.println();
        target.toLowercase("Abc");
    }

    @Test
    public void testRegexAdvisor() {
        AOPTarget target = (AOPTarget) ac.getBean("regexAdvisorProxy");
        target.print();
        System.out.println();
        target.toUppercase("Abc");
        System.out.println();
        target.toLowercase("Abc");
    }
}
