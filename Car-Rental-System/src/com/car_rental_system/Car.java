package com.car_rental_system;

public class Car {
    private String carID;
    private String brand;
    private String model;
    private final double basePricePerDay;
    private boolean isAvailable;

    public Car(String carID, String brand, String model, double basePricePerDay) {
        this.carID = carID;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    public double CalCulateCost(int rentalDays) {
    return rentalDays * basePricePerDay;
    }

    public String getCarID() {
        return carID;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnCar() {
        isAvailable = true;
    }

}
