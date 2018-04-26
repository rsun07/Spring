package pers.xiaoming.java_spring.entity;

public class AOPTargetImpl implements AOPTarget {

    public void print() {
        System.out.println("Executing AOP target class print()");
    }

    public String toUppercase(String str) {
        System.out.println("Executing AOP target class toUppercase()");
        return str.trim().toUpperCase();
    }

    public String toLowercase(String str) {
        System.out.println("Executing AOP target class toLowercase()");
        return str.trim().toLowerCase();
    }

    @Override
    public void throwMyException() throws MyException {
        System.out.println("Executing AOP target class throwMyException()");
        throw new MyException("Throw from throw method");
    }
}
