package ru.geekbrains.seminar1.store3D.inmemory;

import ru.geekbrains.seminar1.store3D.models.Camera;
import ru.geekbrains.seminar1.store3D.models.Flash;
import ru.geekbrains.seminar1.store3D.models.PoligonalModel;
import ru.geekbrains.seminar1.store3D.models.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger {

    private List<ModelChangedObserver> observers = new ArrayList<>();

    private List<PoligonalModel> models = new ArrayList<>();
    private List<Flash> flashes = new ArrayList<>();
    private List<Camera> cameras = new ArrayList<>();
    private List<Scene> scenes = new ArrayList<>();


    public void addModel(PoligonalModel model){
        models.add(model);
        notifyChange("\nДобавление полигональной модели.");
    }

    public void addFlash(Flash flash){
        flashes.add(flash);
        notifyChange("\nДобавление источника света.");
    }

    public void addCamera(Camera camera){
        cameras.add(camera);
        notifyChange("\nДобавление камеры.");
    }

    public void addScene(Scene scene){
        scenes.add(scene);
        notifyChange("\nДобавление сцены.");
    }



    @Override
    public void notifyChange(String message) {
        for (ModelChangedObserver observer : observers){
            observer.applyUpdateModel(message);
        }
    }

    @Override
    public void RegisterModelChanger(ModelChangedObserver o) {
        observers.add(o);
    }

    @Override
    public void RemoveModelChanger(ModelChangedObserver o) {
        observers.remove(o);
    }
}
