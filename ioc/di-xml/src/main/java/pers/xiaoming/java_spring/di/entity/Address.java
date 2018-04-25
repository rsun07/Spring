package pers.xiaoming.java_spring.di.entity;

import java.util.Objects;

public class Address {
    private int num;
    private String street;
    private int zipcode;

    public Address(int num, String street, int zipcode) {
        this.num = num;
        this.street = street;
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return num == address.num &&
                zipcode == address.zipcode &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, street, zipcode);
    }
}
