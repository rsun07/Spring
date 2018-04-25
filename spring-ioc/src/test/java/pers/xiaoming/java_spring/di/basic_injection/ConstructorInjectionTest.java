package pers.xiaoming.java_spring.di.basic_injection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorInjectionTest {
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("basicInjectionContext.xml");

        Car tank = (Car) ctx.getBean("tank");
        System.out.println(tank.toString());

        Car myCar = (Car) ctx.getBean("myCar");
        System.out.println(myCar.toString());

    }
}
