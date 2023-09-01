package ru.geekbrains.seminar1.store3D.models;

import java.util.List;

public class Poligon {

    private static int counter = 0;

    private int id;

    private List<Point3D> points;

    public Poligon(List<Point3D> points) {
        this.points = points;
        this.id = ++counter;
    }


}
