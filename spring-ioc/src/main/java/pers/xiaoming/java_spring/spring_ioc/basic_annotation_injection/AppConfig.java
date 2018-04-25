package pers.xiaoming.java_spring.spring_ioc.basic_annotation_injection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pers.xiaoming.java_spring.spring_ioc.basic_annotation_injection.repository.MyRepository;
import pers.xiaoming.java_spring.spring_ioc.basic_annotation_injection.repository.MyRepositoryImpl;

@Configuration
@ComponentScan({"pers.xiaoming.java_spring.spring_ioc.basic_annotation_injection.autowired_bean",
        "pers.xiaoming.java_spring.spring_ioc.basic_annotation_injection.repository"})
public class AppConfig {

    @Bean
    @Qualifier("My Repository")
    public MyRepository provideMyRepositoryImpl() {
        return new MyRepositoryImpl();
    }
}
