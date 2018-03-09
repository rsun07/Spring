package com.xiaoming.spring.aop_basic;

import com.xiaoming.spring.aop_basic.spring_aop.AppConfig;
import com.xiaoming.spring.aop_basic.traditional_impl.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {
    @Test
    public void test() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Calculator calculator = (Calculator) ctx.getBean("aopCalculator");

        calculator.add(2, 8);
        calculator.sub(8, 3);
    }
}
