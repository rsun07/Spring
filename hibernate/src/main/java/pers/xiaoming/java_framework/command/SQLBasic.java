package pers.xiaoming.java_framework.command;

import org.hibernate.Session;
import pers.xiaoming.java_framework.entity.Student;

import java.util.List;

public class SQLBasic {
    // In SQL, use database table attribute names instead of Java Class field names
    // Should use PreparedStatement in production
    // here is only a demo for how to use Hibernate
    private final static String GET_A_STUDENT_SQL = "SELECT t_id, t_name, t_age, t_score FROM t_student WHERE id = %d LIMIT 10;";

    private final static String GET_TOP_TEN_STUDENT_SQL = "SELECT t_id, t_name, t_age, t_score FROM t_student ORDER BY t_score DESC LIMIT 10;";

    @SuppressWarnings("unchecked")
    public Student getStudent(Session session, int id) {
        try {
            session.beginTransaction();

            List<Student> list = session.createSQLQuery(String.format(GET_A_STUDENT_SQL, id))
                    .addEntity(Student.class).list();

            session.getTransaction().commit();
            return list.get(0);

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Student> getTopTenStudents(Session session, int id) {
        try {
            session.beginTransaction();

            List<Student> list = session.createSQLQuery(GET_TOP_TEN_STUDENT_SQL)
                    .addEntity(Student.class).list();

            session.getTransaction().commit();
            return list;

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
