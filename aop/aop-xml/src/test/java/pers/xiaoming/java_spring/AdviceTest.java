package pers.xiaoming.java_spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdviceTest {
    private ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    private AOPTarget target = (AOPTarget) ac.getBean("aopProxy");

    @Test
    public void testMethodBeforeAdvice() {
        target.print();
        target.toUppercase("Ab!c");
    }
}
