package ru.geekbrains.seminar3;

/**
 * Заправочная станция
 */
interface Refueling{

    /**
     * Заправка
     */
    void fuel(FuelType fuelType);

    String getName();
}
