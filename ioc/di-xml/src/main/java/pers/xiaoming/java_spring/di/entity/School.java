package pers.xiaoming.java_spring.di.entity;

import java.util.Objects;

public class School {
    private String name;
    private Address address;

    public School(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(name, school.name) &&
                Objects.equals(address, school.address);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, address);
    }
}
