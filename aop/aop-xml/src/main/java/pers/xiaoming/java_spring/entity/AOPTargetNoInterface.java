package pers.xiaoming.java_spring.entity;

public class AOPTargetNoInterface {
    public void print() {
        System.out.println("Executing AOP target class print()");
    }

    public String toUppercase(String str) {
        System.out.println("Executing AOP target class toUppercase()");
        return str.trim().toUpperCase();
    }
}
