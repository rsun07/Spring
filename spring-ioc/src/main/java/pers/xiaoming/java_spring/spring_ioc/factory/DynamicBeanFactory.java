package pers.xiaoming.java_spring.spring_ioc.factory;

import pers.xiaoming.java_spring.spring_ioc.entity.MyBean;

public class DynamicBeanFactory {
    public MyBean getMyBean() {
        return new MyBean();
    }
}
