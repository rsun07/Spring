package pers.xiaoming.java_framework.basic;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pers.xiaoming.java_framework.command.basic.CURDStudentBasic;
import pers.xiaoming.java_framework.entity.Student;
import pers.xiaoming.java_framework.session_factory.Server;

//@Ignore("Demo for Hibernate integration test with DB dependency, " +
//        "run it in my macbook or when manually demo")
public class StudentCURDTest {
    private static CURDStudentBasic dbOperator;

    @BeforeClass
    public static void init() {
        dbOperator = new CURDStudentBasic();
    }

    @Test
    public void testCreateAndDelete() {
        Student student = Student.builder().name("John").age(20).score(88.5).build();

        int id = create(getMySession(), student);
        student.setId(id);

        Student studentGetFromDb = get(getSession(),id);
        Assert.assertEquals(student, studentGetFromDb);

        delete(getSession(),id);

        studentGetFromDb = get(getSession(),id);
        Assert.assertNull(studentGetFromDb);
    }

    private int create(Session session, Student student) {
        return dbOperator.create(session, student);
    }

    private Student get(Session session, int id) {
        return dbOperator.get(session, id);
    }

    private void delete(Session session, int id) {
        dbOperator.delete(session, id);
    }

    private Session getSession() {
        return Server.getSession();
    }

    private Session getMySession() {
        return Server.getSession();
    }
}
