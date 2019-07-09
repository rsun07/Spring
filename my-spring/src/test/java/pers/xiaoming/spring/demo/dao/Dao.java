package pers.xiaoming.spring.demo.dao;

public interface Dao {
    void set(String v);

    String[] getAll();

    boolean delete(String v);
}
