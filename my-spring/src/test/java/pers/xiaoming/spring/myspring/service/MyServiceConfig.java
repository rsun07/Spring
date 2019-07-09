package pers.xiaoming.spring.myspring.service;

import lombok.Getter;

class MyServiceConfig {
    @Getter
    private String value;

    MyServiceConfig(String value) {
        this.value = value;
    }
}
