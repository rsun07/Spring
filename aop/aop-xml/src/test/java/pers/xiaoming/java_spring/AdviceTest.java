package pers.xiaoming.java_spring;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Ignore("demo test")
public class AdviceTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("singleAopContext.xml");

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

    @Test(expected = MyException.class)
    public void testThrowsAdvice() throws MyException {
        AOPTarget target = (AOPTarget) ac.getBean("throwsAdviceProxy");
        try {
            target.throwMyException();
        } catch (MyException e) {
            e.getMessage();
            throw e;
        }
    }

    @Test
    public void testMultiAspects() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("multiAspectsAopContext.xml");
        AOPTarget target = (AOPTarget) ac.getBean("multiAspectProxy");

        target.print();
        System.out.println();
        target.toUppercase("Ab!c");
    }
}
