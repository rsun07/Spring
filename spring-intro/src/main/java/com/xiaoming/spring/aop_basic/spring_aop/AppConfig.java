package com.xiaoming.spring.aop_basic.spring_aop;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
@ComponentScan("com.xiaoming.spring.aop_basic.spring_aop")
public class AppConfig {

    // If you use the bean here, the target class must have a constructor!!!
    @Bean(name = "aopCalculatorImpl")
    // set scope the target class,
    // otherwise spring will use <JDK dynamic proxies> by default which only proxy Interface
    // In this case, the bean cannot be cast to Target class, only cast to the interface it implements
    // equals to the xml " <aop:config proxy-target-class="true"/>"
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    public CalculatorAopImpl proviceCalculatorAopImpl() {
        return new CalculatorAopImpl();
    }
}
