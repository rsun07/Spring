package com.xiaoming.spring.basic_annotation_injection;

import com.xiaoming.spring.basic_annotation_injection.repository.MyRepository;
import com.xiaoming.spring.basic_annotation_injection.repository.MyRepositoryImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.xiaoming.spring.basic_annotation_injection.autowired_bean",
        "com.xiaoming.spring.basic_annotation_injection.repository"})
public class AppConfig {

    @Bean
    @Qualifier("My Repository")
    public MyRepository provideMyRepositoryImpl() {
        return new MyRepositoryImpl();
    }
}
