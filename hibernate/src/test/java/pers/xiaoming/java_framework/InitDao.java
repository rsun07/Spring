package pers.xiaoming.java_framework;

import org.testng.annotations.BeforeSuite;
import pers.xiaoming.java_framework.session_factory.Server;

public class InitDao {
    @BeforeSuite
    public static void initDao() {
        Server.getSession();
    }
}
