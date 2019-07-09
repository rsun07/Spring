package pers.xiaoming.spring.myspring;

import pers.xiaoming.spring.myspring.service.MyServiceConfig;

@MyConfiguration
@MyComponentScan("pers.xiaoming.spring.myspring")
public class AppConfig {

    @MyBean
    public MyServiceConfig getMyServiceConfig(@MyValue("myspring.config.service.value") String myValue) {
        return new MyServiceConfig(myValue);
    }



}
