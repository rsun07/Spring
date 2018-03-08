package com.xiaoming.spring.basic_annotation_injection.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("My Repository")
public class MyRepositoryImpl implements MyRepository {

    public String showRepo() {
        return "My Repository";
    }
}
