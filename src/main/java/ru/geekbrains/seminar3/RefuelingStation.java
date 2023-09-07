package ru.geekbrains.seminar3;

public class RefuelingStation implements Refueling {
    private String name;

    public RefuelingStation() {
        this("АЗС №1");
    }

    public RefuelingStation(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void fuel(FuelType fuelType) {
        switch (fuelType) {
            case Diesel -> System.out.println("Заправили дизелем за 10 минут");
            case Gasoline -> System.out.println("Заправили бензином за 7 минут");
        }
    }


}
