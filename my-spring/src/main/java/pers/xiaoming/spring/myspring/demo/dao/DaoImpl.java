package pers.xiaoming.spring.myspring.demo.dao;

import pers.xiaoming.spring.myspring.annotation.MyComponent;

import java.util.HashSet;
import java.util.Set;

@MyComponent
public class DaoImpl implements Dao {
    private Set<String> storage;

    public DaoImpl() {
        System.out.println("DaoImpl Constructor");
        this.storage = new HashSet<>();
    }

    @Override
    public void set(String v) {
        storage.add(v);
    }

    @Override
    public String[] getAll() {
        return (String[]) storage.toArray();
    }

    @Override
    public boolean delete(String v) {
        return storage.remove(v);
    }
}
