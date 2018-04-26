package pers.xiaoming.java_spring;

public class AOPTargetImpl implements AOPTarget {

    public void print() {
        System.out.println("Executing AOP target class print()");
    }

    public String toUppercase(String str) {
        System.out.println("Executing AOP target class toUppercase()");
        return str.trim().toUpperCase();
    }
}
