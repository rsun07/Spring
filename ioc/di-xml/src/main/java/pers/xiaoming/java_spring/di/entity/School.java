package pers.xiaoming.java_spring.di.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

// because testing setter injection
// no need for AllArgsConstructor
@NoArgsConstructor
@Data
public class School {
    private String name;
    private Address address;
}
