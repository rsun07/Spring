package pers.xiaoming.spring.entity;

public interface AOPTarget {
    void print();

    String toUppercase(String str);

    String toLowercase(String str);

    void throwMyException() throws MyException;
}
