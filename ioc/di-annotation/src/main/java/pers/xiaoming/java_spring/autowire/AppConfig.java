package pers.xiaoming.java_spring.autowire;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pers.xiaoming.java_spring.autowire.repository.MyRepository;
import pers.xiaoming.java_spring.autowire.repository.MyRepositoryImpl;

@Configuration
@ComponentScan({"pers.xiaoming.java_spring.autowire.bean",
        "pers.xiaoming.java_spring.autowire.repository"})
public class AppConfig {

    @Bean
    @Qualifier("My Repository")
    public MyRepository provideMyRepositoryImpl() {
        return new MyRepositoryImpl();
    }
}
