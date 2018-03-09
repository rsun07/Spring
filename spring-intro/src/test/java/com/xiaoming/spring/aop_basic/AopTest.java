package com.xiaoming.spring.aop_basic;

import com.xiaoming.spring.aop_basic.spring_aop.AppConfig;
import com.xiaoming.spring.aop_basic.traditional_impl.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
    private final ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    private final Calculator calculator = (Calculator) ctx.getBean("aopCalculator");

    @Test
    public void testBasic() {
        calculator.add(2, 8);
        calculator.sub(8, 3);
        calculator.mul(8,3);
        calculator.div(8,3);
    }

    @Test
    public void testException() {
        // @Begin advice will run
        // @After advice will run even though exception throw
        // @AfterRunning
        calculator.div(1,0);
    }
}
