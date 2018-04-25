package pers.xiaoming.java_spring.spring_ioc.factory;

public class DynamicBeanFactory {
    public MyBean getMyBean() {
        return new MyBean();
    }
}
