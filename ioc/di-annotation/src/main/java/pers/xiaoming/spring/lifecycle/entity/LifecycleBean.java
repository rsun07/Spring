package pers.xiaoming.spring.lifecycle.entity;


import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifecycleBean {

    @Value("Life_Cycle_Bean")
    // not use setter method
    private String name;

    {
        System.out.println("Running Dynamic code block, my bean name is : " + this.name);
    }

    public LifecycleBean() {
        this.name = "Default_name";
        System.out.println("Constructing...");
    }

    // won't run
    void initMethod() {
        System.out.println("Init..., my bean name is : " + name);
    }

    @PostConstruct
    void setUp() {
        System.out.println("Post Construct..., name = " + this.name);
    }

    // not the destroy from java Interface
    @PreDestroy
    void destroyMethod() {
        System.out.println("Destroying...");
    }

    public void setName(String name) {
        System.out.println("Setting name to <" + name + ">");
        this.name = name;
    }


    @Override
    public String toString() {
        return "LifecycleBean{" +
                "name='" + name + '\'' +
                '}' + "\n";
    }
}
