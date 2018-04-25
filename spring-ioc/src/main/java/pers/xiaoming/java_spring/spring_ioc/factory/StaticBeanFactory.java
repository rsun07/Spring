package pers.xiaoming.java_spring.spring_ioc.factory;

public class StaticBeanFactory {
    public static MyBean getMyBean() {
        return new MyBean();
    }
}
