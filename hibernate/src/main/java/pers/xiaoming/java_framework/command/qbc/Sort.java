package pers.xiaoming.java_framework.command.qbc;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import pers.xiaoming.java_framework.command.GetTopTenStudents;
import pers.xiaoming.java_framework.entity.Student;

import java.util.List;

public class Sort implements GetTopTenStudents {
    @SuppressWarnings("unchecked")
    public List<Student> get(Session session) {
        try {
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Student.class);
            criteria.addOrder(Order.desc("score"));
            criteria.add(Restrictions.sizeEq("t_id", 10));

            List<Student> list = criteria.list();

            session.getTransaction().commit();
            return list;

        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        }
    }
}
