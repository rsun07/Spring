package pers.xiaoming.java_spring.di_xml_entity;

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
