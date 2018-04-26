package pers.xiaoming.java_spring.advice;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.xiaoming.java_spring.TestUtils;
import pers.xiaoming.java_spring.entity.AOPTarget;
import pers.xiaoming.java_spring.entity.MyException;

@Ignore("demo test")
public class AdviceTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("singleAdviseContext.xml");

    @Test
    public void testMethodBeforeAdvice() {
        AOPTarget target = (AOPTarget) ac.getBean("beforeAdviceProxy");
        TestUtils.testTarget(target);
    }

    @Test
    public void testAfterReturningAdvice() {
        AOPTarget target = (AOPTarget) ac.getBean("afterAdviceProxy");
        TestUtils.testTarget(target);
    }

    @Test
    public void testMethodInterceptorProxy() {
        AOPTarget target = (AOPTarget) ac.getBean("methodInterceptorProxy");
        TestUtils.testTarget(target);
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
        ApplicationContext ac = new ClassPathXmlApplicationContext("multiAdvicesContext.xml");
        AOPTarget target = (AOPTarget) ac.getBean("multiAspectProxy");
        TestUtils.testTarget(target);
    }
}
