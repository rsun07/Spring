package pers.xiaoming.java_spring.di.autowired_bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pers.xiaoming.java_spring.di.repository.MyRepository;

@Repository
public class MyConstructorAutowired implements MyService {
    private MyRepository myRepo;

    @Autowired
    public MyConstructorAutowired(@Qualifier("myRepo") MyRepository myRepo) {
        this.myRepo = myRepo;
    }

    public String showRepo() {
        return myRepo.showRepo();
    }
}
