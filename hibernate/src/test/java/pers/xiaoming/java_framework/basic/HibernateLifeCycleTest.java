package pers.xiaoming.java_framework.basic;

import org.junit.Assert;
import org.junit.Test;
import pers.xiaoming.java_framework.command.basic.CURDStudentBasic;
import pers.xiaoming.java_framework.entity.Student;
import pers.xiaoming.java_framework.session_factory.Server;

//@Ignore("Demo for Hibernate integration test with DB dependency, " +
//        "run it in my macbook or when manually demo")
public class HibernateLifeCycleTest {

    @Test
    @SuppressWarnings("UnnecessaryLocalVariable")
    public void testTransientToPersistent() {
        CURDStudentBasic dbOperator = new CURDStudentBasic();

        Student student = Student.builder().name("Mike").age(26).score(78.0).build();

        Student studentBeforeCreate = student;

        Assert.assertNull(student.getId());

        int id = dbOperator.create(Server.getSession(), student);

        Student studentAfterCreate = student;

        // after save() or persist()
        // hibernate life cycle will go from "transient" to "persistent"
        // it will be assigned to the instance
        Assert.assertNotNull(student.getId());
        Assert.assertSame(studentBeforeCreate, studentAfterCreate);
        Assert.assertEquals((Integer) id, student.getId());
    }
}
