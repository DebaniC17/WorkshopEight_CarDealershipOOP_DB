package com.ps.models;

public abstract class Contract {
    private String startDate;
    private String endDate;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;

    public Contract(String startDate, String endDate, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}
