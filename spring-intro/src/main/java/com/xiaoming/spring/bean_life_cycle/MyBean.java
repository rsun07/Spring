package com.xiaoming.spring.bean_life_cycle;


public class MyBean {
    private String name;

    MyBean() {
        System.out.println("Constructing...");
    }

    void initMethod() {
        System.out.println("Init...");
    }

    // not the destroy from java Interface
    void destroyMethod() {
        System.out.println("Destroying...");
    }

    public void setName(String name) {
        System.out.println("Setting name to <" + name + ">");
        this.name = name;
    }


    @Override
    public String toString() {
        return "MyBean{" +
                "name='" + name + '\'' +
                '}' + "\n";
    }
}
