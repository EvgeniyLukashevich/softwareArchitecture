package ru.geekbrains.seminar3;

import java.awt.*;

public class Program {

    public static void main(String[] args) {

        // Создадим 3 машины разных типов

        Harvester harvester = new Harvester("Hino", "A300", Color.BLACK, FuelType.Diesel);
        SportCar sportCar = new SportCar("Nissan", "Silvia", Color.RED, FuelType.Gasoline);
        TaxiCar taxi = new TaxiCar("Ford", "Focus", Color.YELLOW, FuelType.Gasoline);

        // Создадим разные АЗС и автомойки

        Refueling refuelingStation1 = new RefuelingStation();
        Refueling refuelingStation2 = new RefuelingStationV2();

        CarWashing carWashingStation1 = new CarWashingStation1();
        CarWashing carWashingStation2 = new CarWashingStation2();

        // Поочередно запустим наши автомобили на заправку, а затем на мойку (выбирая разные услуги)

        harvester.setRefuelingStation(refuelingStation1);
        harvester.fuel();
        sportCar.setRefuelingStation(refuelingStation2);
        sportCar.fuel();
        taxi.setRefuelingStation(refuelingStation1);
        taxi.fuel();

        System.out.println();

        harvester.setCarWashingStation(carWashingStation1);
        harvester.washBody();
        harvester.wipWindshield();
        harvester.wipWheels();

        taxi.setCarWashingStation(carWashingStation1);
        taxi.washBody();
        taxi.wipWheels();
        taxi.wipHeadlights();

        sportCar.setCarWashingStation(carWashingStation2);
        sportCar.washBody();
        sportCar.wipWindshield();
        sportCar.wipMirrors();
        sportCar.wipWheels();


    }


}
