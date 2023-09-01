package ru.geekbrains.seminar1.store3D.models;

import java.awt.Color;

public class Flash {
    private Point3D location;
    private Angle3D angle;
    private Color color;
    private Float power;

    public Flash(Point3D location, Angle3D angle) {
        this(location, angle, Color.WHITE, 1F);
    }

    public Flash(Point3D location, Angle3D angle, Color color) {
        this(location, angle, color, 1F);
    }

    public Flash(Point3D location, Angle3D angle, Float power) {
        this(location, angle, Color.WHITE, power);
    }

    public Flash(Point3D location, Angle3D angle, Color color, Float power) {
        if (power < 0F || power > 1F)
            throw new RuntimeException("Уровень яркости света должен находиться в диапазоне от 0 до 1");
        this.location = location;
        this.angle = angle;
        this.color = color;
        this.power = power;
    }

    public void rotate(Angle3D angle) {
        this.angle = angle;
    }

    public void move(Point3D location) {
        this.location = location;
    }

    public void colorChange(Color color) {
        this.color = color;
    }

    public void powerChange(Float power) {
        this.power = power;
    }

    public Point3D getLocation() {
        return location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public Color getColor() {
        return color;
    }

    public Float getPower() {
        return power;
    }

    public void info() {
        System.out.printf(
                "Расположение источника света: x: %f   y: %f   z: %f\n",
                location.getX(),
                location.getY(),
                location.getZ());
        System.out.printf(
                "Коэффициенты вращения источника света: x: %f   y: %f   z: %f\n",
                angle.getXRotation(),
                angle.getYRotation(),
                angle.getzRotation());
        System.out.printf(
                "Значение цвета (R, G, B): (%d, %d, %d)\n",
                color.getRed(),
                color.getGreen(),
                color.getBlue());
        System.out.printf("Яркость: %f", power);
    }
}
