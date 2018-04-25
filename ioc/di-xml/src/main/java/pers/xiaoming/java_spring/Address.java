package pers.xiaoming.java_spring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// because testing constructor injection
// no need for NoArgsConstructor
@Data
@AllArgsConstructor
public class Address {
    private int num;
    private String street;
    private int zipcode;
}
