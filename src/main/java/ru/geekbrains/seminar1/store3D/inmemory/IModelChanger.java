package ru.geekbrains.seminar1.store3D.inmemory;

public interface IModelChanger {

    /**
     * Произошло изменение в хранилище моделей
     */
    void notifyChange(String message);

    void RegisterModelChanger(ModelChangedObserver o);
    void RemoveModelChanger(ModelChangedObserver o);

}
