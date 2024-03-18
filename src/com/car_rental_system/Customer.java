package com.car_rental_system;

public class Customer {

    private String customerID;
    private String customerName;

    public Customer(String customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
    }

    public String getCustomerID() {
        return customerID;
    }


    public String getCustomerName() {
        return customerName;
    }

}
