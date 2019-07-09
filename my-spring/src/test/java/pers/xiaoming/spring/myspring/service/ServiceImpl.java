package pers.xiaoming.spring.myspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import pers.xiaoming.spring.myspring.dao.Dao;

public class ServiceImpl implements Service {
    private MyServiceConfig config;

    private Dao dao;

    @Autowired
    public ServiceImpl(MyServiceConfig config) {
        this.config = config;
    }

    @Override
    public String get() {
        return dao.get();
    }

    @Override
    public void set(String value) {
        dao.set(value);
    }

    @Override
    public boolean delete(String value) {
        return dao.delete(value);
    }
}
