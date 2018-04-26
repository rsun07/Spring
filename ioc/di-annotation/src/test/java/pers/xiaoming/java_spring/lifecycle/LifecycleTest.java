package pers.xiaoming.java_spring.lifecycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifecycleTest {
    @Test
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    }
}
