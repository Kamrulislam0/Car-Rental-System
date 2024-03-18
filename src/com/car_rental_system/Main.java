package com.car_rental_system;

public class Main {
    public static void main(String[] args) {



         var car1 = new Car("C001", "Lamborghini", "SVC", 1000);
         var car2 = new Car("C002", "Nissan", "GTR", 500);
         var car3 = new Car("C003", "Audi", "R8", 800);
         var car4 = new Car("C004", "BMW", "I8", 750);

        CarRentalSystem carRentalSystem = new CarRentalSystem();
         carRentalSystem.addCar(car1);
         carRentalSystem.addCar(car2);
         carRentalSystem.addCar(car3);
         carRentalSystem.addCar(car4);

         carRentalSystem.menu();
    }
}
