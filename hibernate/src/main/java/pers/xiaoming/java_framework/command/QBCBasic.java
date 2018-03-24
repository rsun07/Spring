package pers.xiaoming.java_framework.command;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import pers.xiaoming.java_framework.entity.Student;

import java.util.List;

public class QBCBasic {

    @SuppressWarnings("unchecked")
    public Student getStudent(Session session, int id) {
        try {
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Student.class);
            criteria.add(Restrictions.like("id", id));

            List<Student> list = criteria.list();

            session.getTransaction().commit();
            return list.get(0);

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public Student getTopTenStudent(Session session, int id) {
        try {
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Student.class);
            criteria.addOrder(Order.desc("score"));
            criteria.add(Restrictions.sizeEq("t_id", 10));

            List<Student> list = criteria.list();

            session.getTransaction().commit();
            return list.get(0);

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
