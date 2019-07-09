package pers.xiaoming.spring.autowire;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pers.xiaoming.spring.autowire.repository.MyRepository;
import pers.xiaoming.spring.autowire.repository.MyRepositoryImpl;

@Configuration
@ComponentScan({"pers.xiaoming.spring.autowire.bean",
        "pers.xiaoming.spring.autowire.repository"})
public class AppConfig {

    @Bean
    @Qualifier("My Repository")
    public MyRepository provideMyRepositoryImpl() {
        return new MyRepositoryImpl();
    }
}
