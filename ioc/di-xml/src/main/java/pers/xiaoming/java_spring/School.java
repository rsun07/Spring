package pers.xiaoming.java_spring;

import lombok.Data;
import lombok.NoArgsConstructor;

// because testing setter injection
// no need for AllArgsConstructor
@Data
@NoArgsConstructor
public class School {
    private String name;
    private Address address;
}
