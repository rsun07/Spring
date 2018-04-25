package pers.xiaoming.java_spring.ioc_basic.bean_life_cycle;


public class LifecycleBean {
    private String name;

    {
        System.out.println("Running Dynamic code block, my bean name is : " + this.name);
    }

    LifecycleBean() {
        this.name = "Default_name";
        System.out.println("Constructing...");
    }

    LifecycleBean(String name) {
        this.name = name;
        System.out.println("Constructing...");
    }

    void initMethod() {
        System.out.println("Init..., my bean name is : " + name);
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
        return "LifecycleBean{" +
                "name='" + name + '\'' +
                '}' + "\n";
    }
}
