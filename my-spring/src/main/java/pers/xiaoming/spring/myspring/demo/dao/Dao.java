package pers.xiaoming.spring.myspring.demo.dao;

public interface Dao {
    void set(String v);

    String[] getAll();

    boolean delete(String v);
}
