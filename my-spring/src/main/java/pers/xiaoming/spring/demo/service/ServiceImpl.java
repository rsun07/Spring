package pers.xiaoming.spring.demo.service;

import pers.xiaoming.spring.demo.dao.Dao;
import pers.xiaoming.spring.myspring.annotation.MyAutowired;
import pers.xiaoming.spring.myspring.annotation.MyService;

@MyService
public class ServiceImpl implements Service {
    private MyServiceConfig config;

    private Dao dao;

    @MyAutowired
    public ServiceImpl(MyServiceConfig config) {
        this.config = config;
    }

    @Override
    public String[] getAll() {
        return dao.getAll();
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
