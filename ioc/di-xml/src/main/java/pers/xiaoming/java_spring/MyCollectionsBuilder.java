package pers.xiaoming.java_spring;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

final class MyCollectionsBuilder {
    private String[] array;
    private List<String> list;
    private Set<String> set;
    private Map<String, Student> map;
    private Properties properties;

    public MyCollectionsBuilder setArray(String[] array) {
        this.array = array;
        return this;
    }

    public MyCollectionsBuilder setList(List<String> list) {
        this.list = list;
        return this;
    }

    public MyCollectionsBuilder setSet(Set<String> set) {
        this.set = set;
        return this;
    }

    public MyCollectionsBuilder setMap(Map<String, Student> map) {
        this.map = map;
        return this;
    }

    public MyCollectionsBuilder setProperties(Properties properties) {
        this.properties = properties;
        return this;
    }

    public MyCollections build() {
        MyCollections myCollections = new MyCollections();
        myCollections.setArray(this.array);
        myCollections.setList(this.list);
        myCollections.setSet(this.set);
        myCollections.setMap(this.map);
        myCollections.setProperties(this.properties);
        return myCollections;
    }
}
