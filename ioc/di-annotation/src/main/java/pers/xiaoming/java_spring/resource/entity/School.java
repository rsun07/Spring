package pers.xiaoming.java_spring.resource.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("mySchool")
public class School {
    @Value("MyUniversity")
    private String name;

    // with name, inject by bean name
    @Resource(name = "schoolAddress")
    private Address address;

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
