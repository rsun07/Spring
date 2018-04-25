package pers.xiaoming.java_spring;

import lombok.Data;
import lombok.NoArgsConstructor;

// because testing setter injection
// no need for AllArgsConstructor
@Data
@NoArgsConstructor
public class Address {
    private int num;
    private String street;
    private int zipcode;
}
