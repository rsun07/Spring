package pers.xiaoming.java_framework.query;

import org.testng.annotations.Test;
import pers.xiaoming.java_framework.command.GetStudent;
import pers.xiaoming.java_framework.command.sql.BasicGet;
import pers.xiaoming.java_framework.entity.Student;
import pers.xiaoming.java_framework.session_factory.Server;

public class SqlGetsTest {
    @Test
    public void testGetStudent() {
        GetStudent getStudent = new BasicGet();
        Student student = getStudent.get(Server.getSession(), 1);
        System.out.println(student);
    }
}
