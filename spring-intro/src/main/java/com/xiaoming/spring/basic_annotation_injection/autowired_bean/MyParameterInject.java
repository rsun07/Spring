package com.xiaoming.spring.basic_annotation_injection.autowired_bean;

import com.xiaoming.spring.basic_annotation_injection.repository.MyRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

@Controller("customized bean name: parameter inject")
public class MyParameterInject implements MyService {
    @Inject
    @Qualifier("My Repository")
    private MyRepository myRepo;

    public String showRepo() {
        return myRepo.showRepo();
    }
}
