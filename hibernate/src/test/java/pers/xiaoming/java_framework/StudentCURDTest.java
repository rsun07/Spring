package pers.xiaoming.java_framework;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pers.xiaoming.java_framework.db.CURDStudent;
import pers.xiaoming.java_framework.entity.Student;

public class StudentCURDTest {
    private static CURDStudent dbOperator;

    @BeforeClass
    public static void init() {
        dbOperator = new CURDStudent();
    }

    @Test
    public void testCreateAndDelete() {
        Student student = Student.builder().name("John").age(20).score(88.5).build();

        int id = create(student);
        student.setId(id);

        Student studentGetFromDb = get(id);
        Assert.assertEquals(student, studentGetFromDb);

        delete(id);

        studentGetFromDb = get(id);
        Assert.assertNull(studentGetFromDb);
    }

    private int create(Student student) {
        Session session = Server.getSession();
        return dbOperator.create(session, student);
    }

    private Student get(int id) {
        Session session = Server.getSession();
        return dbOperator.get(session, id);
    }

    private void delete(int id) {
        Session session = Server.getSession();
        dbOperator.delete(session, id);
    }
}
