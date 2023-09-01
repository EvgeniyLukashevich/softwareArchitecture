package ru.geekbrains.seminar1.store3D.models;

public class Angle3D {
    private double xRotation;
    private double yRotation;
    private double zRotation;

    public Angle3D(double xRotation, double yRotation, double zRotation) {
        if ((xRotation < 0 || xRotation > 1) || (yRotation < 0 || yRotation > 1) || (zRotation < 0 || zRotation > 1))
            throw new RuntimeException("Коэффициент вращения по оси должен быть от 0 до 1");
        this.xRotation = xRotation;
        this.yRotation = yRotation;
        this.zRotation = zRotation;
    }

    public double getXRotation() {
        return xRotation;
    }

    public double getYRotation() {
        return yRotation;
    }

    public double getzRotation() {
        return zRotation;
    }

    public void setXRotation(double xRotation) {
        this.xRotation = xRotation;
    }

    public void setYRotation(double yRotation) {
        this.yRotation = yRotation;
    }

    public void setZRotation(double zRotation) {
        this.zRotation = zRotation;
    }
}
