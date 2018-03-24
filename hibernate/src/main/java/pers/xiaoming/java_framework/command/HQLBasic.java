package pers.xiaoming.java_framework.command;

import org.hibernate.Session;
import pers.xiaoming.java_framework.entity.Student;

import java.sql.PreparedStatement;
import java.util.List;

public class HQLBasic {
    // Student here is class name rather than table name
    // Should use PreparedStatement in production
    // here is only a demo for how to use Hibernate
    private final static String GET_A_STUDENT_HQL = "FROM Student WHERE id = %d;";

    // limit is not supported in HQL,
    // need to use setMaxResults(maxRows) function
    private final static String GET_ALL_STUDENT_HQL = "FROM Student ORDER BY score DESC;";


    @SuppressWarnings("unchecked")
    public Student getStudent(Session session, int id) {
        try {
            session.beginTransaction();

            List<Student> list = session.createSQLQuery(String.format(GET_A_STUDENT_HQL, id))
                    .addEntity(Student.class).list();

            session.getTransaction().commit();
            return list.get(0);

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public Student getTopTenStudent(Session session) {
        try {
            session.beginTransaction();

            List<Student> list = session.createSQLQuery(GET_ALL_STUDENT_HQL)
                    .addEntity(Student.class).list();

            session.getTransaction().commit();
            return list.get(0);

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
