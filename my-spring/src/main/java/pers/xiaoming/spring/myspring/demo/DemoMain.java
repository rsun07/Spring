package pers.xiaoming.spring.myspring.demo;

import pers.xiaoming.spring.myspring.MySpring;
import pers.xiaoming.spring.myspring.annotation.MySpringApp;

@MySpringApp(scanPackage = "pers.xiaoming.spring.myspring.demo")
public class DemoMain {
    public static void main(String[] args) {
        System.out.println("Demo Main is running");
        MySpring.run(DemoMain.class);
    }
}
