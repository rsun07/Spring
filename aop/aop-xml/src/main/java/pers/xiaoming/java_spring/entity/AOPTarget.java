package pers.xiaoming.java_spring.entity;

public interface AOPTarget {
    void print();

    String toUppercase(String str);

    void throwMyException() throws MyException;
}
