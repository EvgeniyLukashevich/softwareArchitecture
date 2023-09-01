package ru.geekbrains.seminar1.store3D;

import ru.geekbrains.seminar1.store3D.inmemory.ModelStore;
import ru.geekbrains.seminar1.store3D.inmemory.Observer1;
import ru.geekbrains.seminar1.store3D.inmemory.Observer2;
import ru.geekbrains.seminar1.store3D.models.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        // Создадим 3 точки, и на их основе создадим полигон и добавим его в список полигонов.

        Point3D point1 = new Point3D(1, 2, 3);
        Point3D point2 = new Point3D(2, 5, 7);
        Point3D point3 = new Point3D(4, 3, 4);
        List<Point3D> points = new ArrayList<>();
        points.add(point1);
        points.add(point2);
        points.add(point3);
        Poligon polygon1 = new Poligon(points);
        List<Poligon> polygons = new ArrayList<>();
        polygons.add(polygon1);


        // Создадим текстуру, и на основе списка полигонов и списка текстур создадим полигональную модель.

        Texture texture = new Texture("Wood");
        List<Texture> textures = new ArrayList<>();
        textures.add(texture);
        PoligonalModel model = new PoligonalModel(polygons, textures);
        List<PoligonalModel> models = new ArrayList<>();
        models.add(model);


        // Создадим пару источников света, задав расположение в пространстве точкой,
        // а угол - коэффициентами вращения по трём осям.
        // Яркость и цвет для первого оставим равными дефолтным значениям, а для второго придумаем.

        Flash flash1 = new Flash(new Point3D(5, 5, 5), new Angle3D(0.5, 0.5, 0.5));
        Flash flash2 = new Flash(new Point3D(7, 1, 7), new Angle3D(0.1, 0.2, 0.3), Color.BLUE, 0.7F);
        List<Flash> flashes = new ArrayList<>();
        flashes.add(flash1);
        flashes.add(flash2);


        // Создадим камеру, также передав её расположение и угол.

        Camera camera = new Camera(new Point3D(11, 7, 9), new Angle3D(0.9, 0.8, 0.7));


        // Создадим сцену, используя созданные ранее список полигональных моделей, список источников света и камеру.

        Scene scene = new Scene(models, flashes, camera);


        // Проверим, работает ли вращение/передвижение источников света/камеры в нашей сцене.
        // Также проверим работает ли смена цвета и яркости источников света.

        System.out.println("##### ИСХОДНЫЕ ПАРАМЕТРЫ #####");
        scene.info();

        scene.moveCamera(new Point3D(1.1, 1.1, 1.1));
        scene.rotateCamera(new Angle3D(0.1, 0.1, 0.1));
        scene.moveFlash(1, new Point3D(2.1, 2.1, 2.1));
        scene.moveFlash(2, new Point3D(2.2, 2.2, 2.2));
        scene.rotateFlash(1, new Angle3D(0.2, 0.2, 0.2));
        scene.rotateFlash(2, new Angle3D(0.3, 0.3, 0.3));
        scene.changeFlashColor(1, Color.CYAN);
        scene.changeFlashColor(2, Color.GREEN);
        scene.changeFlashPower(1, 0.5F);
        scene.changeFlashPower(2, 0.99F);

        System.out.println("\n\n##### НОВЫЕ ПАРАМЕТРЫ #####");
        scene.info();


        // Добавим наблюдателей, добавим созданные нами ранее сущности в ModelStore.
        // Проверим, отреагируют ли наблюдатели на добавление сущностей

        ModelStore store = new ModelStore();

        Observer1 observer1 = new Observer1();
        Observer2 observer2 = new Observer2();
        store.RegisterModelChanger(observer1);
        store.RegisterModelChanger(observer2);

        store.addModel(model);
        store.addCamera(camera);
        store.addFlash(flash1);
        store.addFlash(flash2);
        store.addScene(scene);
    }

}
