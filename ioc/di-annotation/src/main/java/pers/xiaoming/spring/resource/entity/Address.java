package pers.xiaoming.spring.resource.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("schoolAddress")
public class Address {
    @Value("8888")
    private int num;

    @Value("CA DR")
    private String street;

    @Value("12345")
    private int zipcode;

    @Override
    public String toString() {
        return "Address{" +
                "num=" + num +
                ", street='" + street + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
