package pers.xiaoming.java_spring.di.autowired_bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pers.xiaoming.java_spring.di.repository.MyRepository;

@Component
public class MySetterAutowired implements MyService {
    private MyRepository myRepo;

    @Autowired
    public void setMyRepo(@Qualifier("myRepo") MyRepository myRepo) {
        this.myRepo = myRepo;
    }

    public String showRepo() {
        return myRepo.showRepo();
    }
}
