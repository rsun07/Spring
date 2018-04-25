package pers.xiaoming.java_spring.spring_ioc.basic_injection;

import java.util.List;
import java.util.Map;

public class Person {
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' + "\n" +
                ", cars=" + cars + "\n" +
                ", carMap=" + carMap + "\n" +
                '}';
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setCarMap(Map<String, Car> carMap) {
        this.carMap = carMap;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    private List<Car> cars;

    private Map<String, Car> carMap;
}
