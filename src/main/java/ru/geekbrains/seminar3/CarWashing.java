package ru.geekbrains.seminar3;

public interface CarWashing {

    public String getName();
    void washBody(CarType carType);

    void wipMirrors();

    void wipWindshield(CarType carType);

    void wipHeadlights();

    void wipWheels(int wheelsCount);
}
