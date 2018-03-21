package com.xiaoming.spring.basic_injection;

import java.util.Objects;

public class Engine {
    private int volumn;

    public Engine(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return volumn == engine.volumn;
    }

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
