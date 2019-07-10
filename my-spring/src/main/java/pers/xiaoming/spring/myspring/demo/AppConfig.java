package pers.xiaoming.spring.myspring.demo;

import pers.xiaoming.spring.myspring.demo.service.MyServiceConfig;
import pers.xiaoming.spring.myspring.annotation.MyBean;
import pers.xiaoming.spring.myspring.annotation.MyConfiguration;
import pers.xiaoming.spring.myspring.annotation.MyValue;

@MyConfiguration
public class AppConfig {

    public AppConfig() {
        System.out.println("App Config Constructor");
    }

    @MyBean
    public MyServiceConfig getMyServiceConfig(@MyValue("myspring.config.service.value") String myValue) {
        System.out.println("getMyServiceConfig get called inside AppConfig, property value is : " + myValue);
        return new MyServiceConfig(myValue);
    }
}
