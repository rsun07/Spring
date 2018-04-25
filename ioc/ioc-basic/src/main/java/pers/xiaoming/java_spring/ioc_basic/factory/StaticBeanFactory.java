package pers.xiaoming.java_spring.ioc_basic.factory;

import pers.xiaoming.java_spring.ioc_basic.entity.MyBean;

public class StaticBeanFactory {
    public static MyBean getMyBean() {
        return new MyBean();
    }
}
