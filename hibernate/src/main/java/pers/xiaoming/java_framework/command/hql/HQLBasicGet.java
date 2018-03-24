package pers.xiaoming.java_framework.command.hql;

import org.hibernate.Session;
import pers.xiaoming.java_framework.entity.Student;

import java.sql.PreparedStatement;
import java.util.List;

public class HQLBasicGet {
    // Student here is class name rather than table name
    private final static String GET_A_STUDENT_HQL_WILDCARD = "FROM Student WHERE id = ?;";

    private final static String GET_A_STUDENT_HQL_PARAM = "FROM Student WHERE id = :id;";

    // limit is not supported in HQL,
    // need to use setMaxResults(maxRows) function
    private final static String GET_ALL_STUDENT_HQL = "FROM Student ORDER BY score DESC;";


    @SuppressWarnings("unchecked")
    public Student getStudent(Session session, int id) {
        try {
            session.beginTransaction();

//            List<Student> list = session.createQuery(GET_A_STUDENT_HQL_WILDCARD)
//                    .setInteger(0, id).list();
            List<Student> list = session.createQuery(GET_A_STUDENT_HQL_PARAM)
                    .setInteger("id", id).list();

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

            // no need for addEntity()
            List<Student> list = session.createSQLQuery(GET_ALL_STUDENT_HQL).setMaxResults(10).list();

            session.getTransaction().commit();
            return list.get(0);

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
