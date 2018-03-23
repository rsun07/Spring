package com.xiaoming.java_framwork.spring_basic.basic_injection;


public class Car {

    private String type;
    private String model;
    private double price;
    private int maxSpeed;

    public Engine getEngine() {
        return engine;
    }

    private Engine engine;

    public Car(String type, double price, int maxSpeed) {
        this.type = type;
        this.price = price;
        this.maxSpeed = maxSpeed;
    }

    public Car(String type, String model, double price, Engine engine) {
        this.type = type;
        this.model = model;
        this.price = price;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                ", engine=" + engine +
                '}';
    }
}
