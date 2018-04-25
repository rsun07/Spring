package pers.xiaoming.java_spring;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

@Data
public class MyCollections {
    private String[] array;
    private List<String> list;
    private Set<String> set;
    private Map<String, Student> map;
    private Properties properties;

    public MyCollections() {
    }

    public static MyCollectionsBuilder builder() {
        return new MyCollectionsBuilder();
    }
}
