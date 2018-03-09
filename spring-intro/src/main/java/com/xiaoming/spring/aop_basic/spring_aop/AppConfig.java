package com.xiaoming.spring.aop_basic.spring_aop;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xiaoming.spring.aop_basic.spring_aop")
public class AppConfig {

    @Bean
    @Qualifier("aopCalculatorImpl")
    public CalculatorAopImpl proviceCalculatorAopImpl() {
        return new CalculatorAopImpl();
    }
}
