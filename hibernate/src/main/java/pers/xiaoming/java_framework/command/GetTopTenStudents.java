package pers.xiaoming.java_framework.command;

import org.hibernate.Session;
import pers.xiaoming.java_framework.entity.Student;

import java.util.List;

public interface GetTopTenStudents {
    List<Student> get(Session session);
}
