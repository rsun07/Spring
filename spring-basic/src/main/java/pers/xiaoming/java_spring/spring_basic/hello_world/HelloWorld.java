package pers.xiaoming.java_spring.spring_basic.hello_world;

public class HelloWorld {

    private String message;

    HelloWorld() {
        System.out.println("Hello World Constructor");
    }

    public void setMessage(String message) {
        System.out.println("Set name : " + message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
