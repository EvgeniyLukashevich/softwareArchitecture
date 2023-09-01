package ru.geekbrains.seminar1.store3D.models;

public class Camera {
    private Point3D location;
    private Angle3D angle;

    public Camera(Point3D location, Angle3D angle) {
        this.location = location;
        this.angle = angle;
    }

    public void rotate(Angle3D angle) {
        this.angle = angle;
    }

    public void move(Point3D location) {
        this.location = location;
    }

    public Point3D getLocation() {
        return location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public void info() {
        System.out.printf(
                "Расположение камеры: x: %f   y: %f   z: %f\n",
                location.getX(),
                location.getY(),
                location.getZ());
        System.out.printf(
                "Коэффициенты вращения камеры: x: %f   y: %f   z: %f\n",
                angle.getXRotation(),
                angle.getYRotation(),
                angle.getzRotation());
    }
}
