package pers.xiaoming.spring.myspring.demo.service;

import lombok.Getter;

public class MyServiceConfig {
    @Getter
    private String value;

    public MyServiceConfig(String value) {
        System.out.println("MyServiceConfig Constructor");
        this.value = value;
    }
}
