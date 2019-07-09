package pers.xiaoming.spring.demo;

import pers.xiaoming.spring.myspring.MySpring;
import pers.xiaoming.spring.myspring.annotation.MySpringApp;

@MySpringApp(scanPackage = "pers.xiaoming.spring.myspring.demo")
public class Main {
    public static void main(String[] args) {
        MySpring.run(Main.class);
    }
}
