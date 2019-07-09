package pers.xiaoming.spring.demo.service;

import lombok.Getter;

public class MyServiceConfig {
    @Getter
    private String value;

    public MyServiceConfig(String value) {
        this.value = value;
    }
}
