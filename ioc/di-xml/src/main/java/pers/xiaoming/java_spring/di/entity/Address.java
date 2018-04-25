package pers.xiaoming.java_spring.di.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

// because testing setter injection
// no need for AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    private int num;
    private String street;
    private int zipcode;
}
