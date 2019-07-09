package pers.xiaoming.spring.myspring;

public class MySpring {
    public static void run(Class mainClass) {
        MySpringInitializer initializer = new MySpringInitializer();
        initializer.init(mainClass);
    }
}
