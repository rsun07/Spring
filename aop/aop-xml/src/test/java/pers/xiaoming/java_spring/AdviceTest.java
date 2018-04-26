package pers.xiaoming.java_spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdviceTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testMethodBeforeAdvice() {
        AOPTarget target = (AOPTarget) ac.getBean("beforeAdviceProxy");
        target.print();
        System.out.println();
        target.toUppercase("Ab!c");
    }

    @Test
    public void testAfterReturningAdvice() {
        AOPTarget target = (AOPTarget) ac.getBean("afterAdviceProxy");
        target.print();
        System.out.println();
        target.toUppercase("Ab!c");
    }

    @Test
    public void testMethodInterceptorProxy() {
        AOPTarget target = (AOPTarget) ac.getBean("methodInterceptorProxy");
        target.print();
        System.out.println();
        target.toUppercase("Ab!c");
    }
}
