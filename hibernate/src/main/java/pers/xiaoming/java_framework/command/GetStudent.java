package pers.xiaoming.java_framework.command;

import org.hibernate.Session;
import pers.xiaoming.java_framework.entity.Student;

public interface GetStudent {
    Student get(Session session, int id);
}
