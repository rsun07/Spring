package pers.xiaoming.spring.demo;

import pers.xiaoming.spring.demo.service.MyServiceConfig;
import pers.xiaoming.spring.myspring.annotation.MyBean;
import pers.xiaoming.spring.myspring.annotation.MyConfiguration;
import pers.xiaoming.spring.myspring.annotation.MyValue;

@MyConfiguration
public class AppConfig {

    @MyBean
    public MyServiceConfig getMyServiceConfig(@MyValue("myspring.config.service.value") String myValue) {
        return new MyServiceConfig(myValue);
    }



}
