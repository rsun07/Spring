package pers.xiaoming.spring.myspring;

import java.util.Map;

public class MySpringContext {
    private Map<String, Object> beanMap;

    MySpringContext(Map<String, Object> beanMap) {
        this.beanMap = beanMap;
    }

    public Object getBean(String name) {
        return beanMap.get(name);
    }
}
