package com.car_rental_system;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {

    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;


    public CarRentalSystem() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }



    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(Car car, Customer customer, int days) {

        if (car.isAvailable()) {
            rentals.add(new Rental(car, customer, days));
        } else {
            System.out.println("Car is not available for rent.");
        }
        car.rent();
    }

    public void returnCar(Car car) {
        Rental rentalToRemove = null;

        for (Rental rental : rentals) {

            if (rental.getCar().equals(car)) {
                rentalToRemove = rental;
                break;
            }
        }

        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
        } else {
            System.out.println("Car was not rented");
        }
    }

    public void menu() {

        while (true) {

            System.out.println("Welcome to Tan Car Rental System!");
            System.out.println("====================================");
            System.out.println("Do you want to :-");
            System.out.println("1. Rent a car \n2.Return a car\n3.Exit from the System");
            System.out.print("Enter your choice: ");

            Scanner sc = new Scanner(System.in);
            int choice = Integer.parseInt(sc.nextLine());


            if (choice == 3) {
                System.out.println("Thanks for being with us :)");
                break;
            }


            if (choice == 1) {

                System.out.print("Enter your name: ");
                String customerName = sc.nextLine();

                String customerID = ("CUS" + (customers.size() + 1));

                System.out.println("\nAvailable cars");
                for (Car car : cars) {

                    if(car.isAvailable())
                        System.out.println(car.getCarID() + " " + car.getBrand() + " " + car.getModel());
                }

                System.out.print("Enter the car ID you want to rent: ");
                String carID = sc.nextLine().toUpperCase();
//                carID = carID.toUpperCase();



                Customer newCustomer = new Customer(customerID, customerName);
                customers.add(newCustomer);

                Car selectedCar = null;
                for (Car car : cars) {
                    if (car.getCarID().equals(carID) && car.isAvailable()) {
                        selectedCar = car;
                        break;
                    }
                }

                if (selectedCar != null) {

                    System.out.print("For how many days you want to rent : ");
                    int rentalDays = Integer.parseInt(sc.nextLine());

                    double bill = selectedCar.CalCulateCost(rentalDays);

                    System.out.println("\n==Rental information==\n");
                    System.out.println("Customer name    : " + customerName);
                    System.out.println("Customer ID      : " + customerID);
                    System.out.println("Car              : " + selectedCar.getBrand() + " " + selectedCar.getModel());
                    System.out.println("Renting for days : " + rentalDays);
                    System.out.println("Total bill       : $" + bill);

                    System.out.println("Confirm rental (Y/N)");
                    String confirm = sc.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {

                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("Car rented successfully\n");
                    } else if (confirm.equalsIgnoreCase("N")) {
                        System.out.println("You cancelled your order.\n");
                    } else {
                        System.out.println("Invalid input\n");
                    }
                } else {
                    System.out.println("\nInvalid car selection\n");
                }


                if(!SessionContinuer()) {
                    break;
                }


            } else if (choice == 2) {
                System.out.println("\n==Return car==\n");
                System.out.print("enter car ID :");
                String carId = sc.nextLine().toUpperCase();
//                carId = carId.toUpperCase();

                Car carToReturn = null;
                for (Car car : cars) {
                    if (car.getCarID().equals(carId) && !car.isAvailable()) {
                        carToReturn = car;
                        break;
                    }
                }

                if (carToReturn != null) {
                    Customer customer = null;
                    for (Rental rental : rentals) {
                        if (rental.getCar().equals(carToReturn)) {
                            customer = rental.getCustomer();
                            break;
                        }
                    }

                    if (customer != null) {
                        returnCar(carToReturn);
                        System.out.println("\nCar successfully returned by " + customer.getCustomerName() + ".\n");
                    } else {
                        System.out.println("\nCar wasn't rented or information is missing!\n");
                    }
                }

                if(!SessionContinuer()) {
                    break;
                }

            }
        }
    }


    private boolean SessionContinuer() {

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("Do you want to continue this session?(Y/N): ");
            String sessionContinuer = sc.nextLine();
            System.out.println();

            if (sessionContinuer.equalsIgnoreCase("Y")) {
                System.out.println("Restarting the session.........\n");
                return true;
            } else if (sessionContinuer.equalsIgnoreCase("N")) {
                System.out.println("Thanks for being with us :)\n");
                return false;
            } else {
                System.out.println("Invalid input\n");

            }
        }

    }

}
