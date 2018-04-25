package pers.xiaoming.java_spring.spring_ioc.factory;

import pers.xiaoming.java_spring.spring_ioc.entity.MyBean;

public class StaticBeanFactory {
    public static MyBean getMyBean() {
        return new MyBean();
    }
}
