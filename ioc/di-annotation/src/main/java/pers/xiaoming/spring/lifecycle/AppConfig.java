package pers.xiaoming.spring.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pers.xiaoming.spring.lifecycle.entity.LifecycleBean;
@Configuration
@ComponentScan({"pers.xiaoming.spring.lifecycle.entity"})
public class AppConfig {

    @Bean
    public LifecycleBean setLifeCycleBean() {
        return new LifecycleBean();
    }
}
