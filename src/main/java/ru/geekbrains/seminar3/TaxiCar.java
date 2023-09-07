package ru.geekbrains.seminar3;

import java.awt.*;

public class TaxiCar extends Car implements Fueling, Washing {

    private Refueling refueling;
    private CarWashing carWashing;

    public TaxiCar(String make, String model, Color color, FuelType fuelType) {
        super(make, model, color, fuelType);
        this.type = CarType.Sedan;
        setWheelsCount(4);
    }

    public void setRefuelingStation(Refueling refuelingStation) {
        this.refueling = refuelingStation;
        System.out.printf("\n### %s принимает клиента %s %s ###\n\n",
                refuelingStation.getName(), this.make, this.model);
    }

    public void setCarWashingStation(CarWashing carWashingStation) {
        this.carWashing = carWashingStation;
        System.out.printf("\n### %s принимает клиента %s %s ###\n\n",
                carWashingStation.getName(), this.make, this.model);
    }

    /**
     * Заправить автомобиль
     */
    @Override
    public void fuel() {
        if (refueling != null) {
            refueling.fuel(fuelType);
        }
    }

    @Override
    public void wipWindshield() {
        if (this.carWashing != null)
            this.carWashing.wipWindshield(this.type);
    }

    @Override
    public void wipMirrors() {
        if (this.carWashing != null)
            this.carWashing.wipMirrors();
    }

    @Override
    public void wipHeadlights() {
        if (this.carWashing != null)
            this.carWashing.wipHeadlights();
    }

    @Override
    public void washBody() {
        if (this.carWashing != null)
            this.carWashing.washBody(this.type);
    }

    @Override
    public void wipWheels() {
        if (this.carWashing != null)
            this.carWashing.wipWheels(this.getWheelsCount());
    }


    @Override
    public void movement() {

    }

    @Override
    public void maintenance() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }

}
