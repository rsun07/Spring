package pers.xiaoming.java_spring;

import lombok.AllArgsConstructor;
import lombok.Data;

// because testing setter injection
// no need for AllArgsConstructor
@Data
public class School {
    private String name;
    private Address address;

    public School(String name) {
        this.name = name;
    }
}
