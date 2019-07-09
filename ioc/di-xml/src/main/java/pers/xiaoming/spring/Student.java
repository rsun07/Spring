package pers.xiaoming.spring;

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
