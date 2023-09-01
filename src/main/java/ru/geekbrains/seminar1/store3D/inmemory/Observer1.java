package ru.geekbrains.seminar1.store3D.inmemory;

public class Observer1 implements ModelChangedObserver{
    @Override
    public void applyUpdateModel(String message) {
        System.out.println(message);
        System.out.println("В ModelStore добавлена новая сущность  - observer#1");
    }
}
