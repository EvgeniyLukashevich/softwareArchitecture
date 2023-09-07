package ru.geekbrains.seminar3;

public class CarWashingStation2 implements CarWashing {
    private String name;

    public CarWashingStation2() {
        this("Автомойка №2");
    }

    public CarWashingStation2(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void washBody(CarType carType) {
        switch (carType) {
            case Sedan -> System.out.println("Кузов чист. К оплате 2000 рублей.");
            case Hatchback -> System.out.println("Кузов чист. К оплате 2500 рублей.");
            case Pickup -> System.out.println("Кузов чист. К оплате 3000 рублей.");
            case Sport -> System.out.println("Кузов чист. К оплате 2200 рублей.");
            case Truck -> System.out.println("Кузов чист. К оплате 3500 рублей.");
        }
    }

    @Override
    public void wipMirrors() {
        System.out.println("Зеркала протерты насухо. К оплате 1000 рублей");
    }

    @Override
    public void wipWindshield(CarType carType) {
        switch (carType) {
            case Sport -> System.out.println("На лобовом стекле не осталось ни одного развода. К оплате 1000 рублей.");
            case Truck -> System.out.println("На лобовом стекле не осталось ни одного развода. К оплате 1300 рублей.");
            default -> System.out.println("На лобовом стекле не осталось ни одного развода. К оплате 1500 рублей.");
        }
    }

    @Override
    public void wipHeadlights() {
        System.out.println("Фары снова могут освещать дорогу. К оплате 100 рублей");
    }

    @Override
    public void wipWheels(int wheelsCount) {
        int price = 50 * wheelsCount;
        System.out.printf("Диски блестят, а покрышки - как новые. К оплате %d рублей\n", price);
    }
}
