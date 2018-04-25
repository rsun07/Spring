package pers.xiaoming.java_spring.di_xml_entity;

import lombok.Data;
import lombok.NoArgsConstructor;

// because testing setter injection
// no need for AllArgsConstructor
@Data
@NoArgsConstructor
public class Student {
    private String name;
    private int age;
    private School school;
}
