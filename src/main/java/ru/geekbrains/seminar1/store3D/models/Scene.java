package ru.geekbrains.seminar1.store3D.models;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Scene {
    private static int counter = 0;
    private int id;
    private List<PoligonalModel> models = new ArrayList<>();
    private List<Flash> flashes = new ArrayList<>();
    private Camera camera;

    public Scene(List<PoligonalModel> models, List<Flash> flashes, Camera camera) {
        if (models == null || flashes == null || models.isEmpty() || flashes.isEmpty())
            throw new RuntimeException("Списки моделей и освещения не должны быть пустыми");
        this.models = models;
        this.flashes = flashes;
        this.camera = camera;
        this.id = ++counter;
    }

    public void rotateCamera(Angle3D angle) {
        camera.rotate(angle);
    }

    public void moveCamera(Point3D location) {
        camera.move(location);
    }

    public void rotateFlash(int flashNumber, Angle3D angle) {
        if (flashNumber > flashes.size() || flashNumber < 1)
            throw new RuntimeException("Неверный номер источника освещения");
        flashes.get(flashNumber - 1).rotate(angle);
    }

    public void moveFlash(int flashNumber, Point3D location) {
        if (flashNumber > flashes.size() || flashNumber < 1)
            throw new RuntimeException("Неверный номер источника освещения");
        flashes.get(flashNumber - 1).move(location);
    }

    public void changeFlashColor(int flashNumber, Color color) {
        if (flashNumber > flashes.size() || flashNumber < 1)
            throw new RuntimeException("Неверный номер источника освещения");
        flashes.get(flashNumber-1).colorChange(color);
    }

    public void changeFlashPower(int flashNumber, Float power) {
        if (flashNumber > flashes.size() || flashNumber < 1)
            throw new RuntimeException("Неверный номер источника освещения");
        if (power <0F || power >1F)
            throw new RuntimeException ("Уровень яркости света должен находиться в диапазоне от 0 до 1");
        flashes.get(flashNumber-1).powerChange(power);
    }

    public void info() {
        System.out.println("\n### КАМЕРА ###");
        this.camera.info();
        int count = 1;
        for (int i=1; i<=flashes.size(); i++){
            System.out.printf("\n### ИСТОЧНИК СВЕТА %d ###\n", i);
            flashes.get(i-1).info();
            System.out.println();
        }
    }

}
