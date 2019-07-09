package pers.xiaoming.spring.jdk_dynamic_proxy.advanced;

public class ChargerImpl implements Chargable {
    @Override
    public void charge() {
        System.out.println("Charging the Calculator, " + this.getClass().getName());
    }
}
