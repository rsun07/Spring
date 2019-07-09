package pers.xiaoming.spring.ioc_basic.factory;

import pers.xiaoming.spring.ioc_basic.entity.MyBean;

public class DynamicBeanFactory {
    public MyBean getMyBean() {
        return new MyBean();
    }
}
