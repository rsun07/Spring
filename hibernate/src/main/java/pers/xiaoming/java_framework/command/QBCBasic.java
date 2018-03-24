package pers.xiaoming.java_framework.command;

import org.hibernate.Session;
import pers.xiaoming.java_framework.entity.Student;

import java.util.List;

public class QBCBasic {

    @SuppressWarnings("unchecked")
    public Student getStudent(Session session, int id) {
        try {
            session.beginTransaction();

            List<Student> list = session.createCriteria(Student.class).list();

            session.getTransaction().commit();
            return list.get(0);

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
