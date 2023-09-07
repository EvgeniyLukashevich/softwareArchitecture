package ru.geekbrains.seminar3;

public class RefuelingStationV2 implements Refueling {

    private String name;

    public RefuelingStationV2() {
        this("АЗС №2");
    }

    public RefuelingStationV2(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void fuel(FuelType fuelType) {
        switch (fuelType) {
            case Diesel -> System.out.println("Заправили дизелем за 5 минут");
            case Gasoline -> System.out.println("Заправили бензином за 8 минут");
        }
    }
}