package pers.xiaoming.spring.ioc_basic.factory;

import pers.xiaoming.spring.ioc_basic.entity.MyBean;

public class StaticBeanFactory {
    public static MyBean getMyBean() {
        return new MyBean();
    }
}
