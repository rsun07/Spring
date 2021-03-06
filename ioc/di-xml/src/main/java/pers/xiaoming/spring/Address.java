package pers.xiaoming.spring;

import lombok.AllArgsConstructor;
import lombok.Data;

// because testing constructor injection
// no need for NoArgsConstructor
@Data
@AllArgsConstructor
public class Address {
    private int num;
    private String street;
    private int zipcode;
}
