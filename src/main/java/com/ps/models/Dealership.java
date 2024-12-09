package com.ps.models;

import java.util.ArrayList;

public class Dealership {
    private int dealershipId;
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory; //..might be unnecessary

    public Dealership() {}

    public Dealership(String phone, String address, String name, int dealershipId) {
        this.phone = phone;
        this.address = address;
        this.name = name;
        this.dealershipId = dealershipId;
    }

    public Dealership(int dealershipId, String name, String address, String phone, ArrayList<Vehicle> inventory) {
        this.dealershipId = dealershipId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = inventory;
    }

    public int getDealershipId() {
        return dealershipId;
    }

    public void setDealershipId(int dealershipId) {
        this.dealershipId = dealershipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Vehicle> inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "dealershipId=" + dealershipId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
