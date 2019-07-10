package pers.xiaoming.spring.myspring;

import java.util.Map;

public class MySpring {
    private static Map<String, Object> beanMap;

    private static MySpringContext mySpringContext;

    public static void run(Class mainClass) {
        MySpringInitializer initializer = new MySpringInitializer();
        beanMap = initializer.init(mainClass);
    }

    public static MySpringContext getSpringContext() {
        if (mySpringContext == null) {
            synchronized (MySpringContext.class) {
                mySpringContext = new MySpringContext(beanMap);
            }
        }
        return mySpringContext;
    }
}
