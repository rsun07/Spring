package com.xiaoming.spring.basic_injection;

public class Engine {
    private int volumn;


    public Engine(int volumn) {
        this.volumn = volumn;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "volumn=" + volumn +
                '}';
    }
}
