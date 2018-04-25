package pers.xiaoming.java_spring.di.entity;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private School school;

    public Student(String name, int age, School school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(school, student.school);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, school);
    }
}
