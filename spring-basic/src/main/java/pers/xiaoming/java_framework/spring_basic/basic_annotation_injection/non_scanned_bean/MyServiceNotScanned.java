package pers.xiaoming.java_framework.spring_basic.basic_annotation_injection.non_scanned_bean;

import pers.xiaoming.java_framwork.spring_basic.basic_annotation_injection.autowired_bean.MyService;
import pers.xiaoming.java_framwork.spring_basic.basic_annotation_injection.repository.MyRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component("not scanned")
public class MyServiceNotScanned implements MyService {
    @Inject
    @Qualifier("My Repository")
    private MyRepository myRepo;

    public String showRepo() {
        return myRepo.showRepo();
    }
}
