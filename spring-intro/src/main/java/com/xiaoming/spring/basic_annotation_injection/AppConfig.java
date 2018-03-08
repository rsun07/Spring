package com.xiaoming.spring.basic_annotation_injection;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.xiaoming.spring.basic_annotation_injection.autowired_bean",
        "com.xiaoming.spring.basic_annotation_injection.repository"})
public class AppConfig {

}
