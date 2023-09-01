package ru.geekbrains.seminar1.store3D.inmemory;

public class Observer2 implements ModelChangedObserver{
    @Override
    public void applyUpdateModel(String message) {
        System.out.println(message);
        System.out.println("В ModelStore добавлена новая сущность  - observer#2");
    }
}
