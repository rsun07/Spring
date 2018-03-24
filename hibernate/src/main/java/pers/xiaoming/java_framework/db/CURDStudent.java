package pers.xiaoming.java_framework.db;

import org.hibernate.Session;
import pers.xiaoming.java_framework.entity.Student;

public class CURDStudent {

    public int create(Session session, Student student) {
        try {
            session.beginTransaction();
            int id = (int) session.save(student);
            session.getTransaction().commit();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            throw e;
        }
    }

    public void delete(Session session, int id) {
        try {
            session.beginTransaction();
            session.delete(Student.builder().id(id).build());
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            throw e;
        }
    }

    public void update(Session session, Student student) {
        try {
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            throw e;
        }
    }

    public Student get(Session session, int id) {
        try {
            session.beginTransaction();
            Student studentFind = session.get(Student.class, id);
            session.getTransaction().commit();
            return studentFind;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            throw e;
        }
    }
}
