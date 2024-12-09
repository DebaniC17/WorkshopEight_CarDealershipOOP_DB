package com.ps.models;

import java.util.ArrayList;
import java.util.List;

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
//    public Dealership(String name, String address, String phone) {
//        this.name = name;
//        this.address = address;
//        this.phone = phone;
//
//        this.inventory = new ArrayList<>();
//    }
//
//    public List<Vehicle> getVehicleByPrice(double min, double max) {
//        List<Vehicle> result = new ArrayList<>();
//        for (Vehicle vehicle : inventory) {
//            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
//                result.add(vehicle);
//            }
//        }
//        return result;
//    }
//
//    public List<Vehicle> getVehicleByMakeModel(String make, String model) {
//        List<Vehicle> result = new ArrayList<>();
//        for (Vehicle vehicle : inventory) {
//            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
//                result.add(vehicle);
//            }
//        }
//        return result;
//    }
//
//    public List<Vehicle> getVehicleByYear(int minYear, int maxYear) {
//        List<Vehicle> result = new ArrayList<>();
//        for (Vehicle vehicle : inventory) {
//            if (vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear) {
//                result.add(vehicle);
//            }
//        }
//        return result;
//    }
//
//    public List<Vehicle> getVehicleByColor(String color) {
//        List<Vehicle> result = new ArrayList<>();
//        for (Vehicle vehicle : inventory) {
//            if (vehicle.getColor().equalsIgnoreCase(color)) {
//                result.add(vehicle);
//            }
//        }
//
//        return result;
//    }
//
//    public List<Vehicle> getVehicleByMileage(int min, int max) {
//        List<Vehicle> result = new ArrayList<>();
//        for (Vehicle vehicle : inventory) {
//            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
//                result.add(vehicle);
//            }
//        }
//        return result;
//    }
//
//    public List<Vehicle> getVehicleByType(String type) {
//        List<Vehicle> result = new ArrayList<>();
//        for (Vehicle vehicle : inventory) {
//            if (vehicle.getVehicleType().equalsIgnoreCase(type)) {
//                result.add(vehicle);
//            }
//        }
//        return null;
//    }
//
//    public List<Vehicle> getAllVehicles() {
//        return this.inventory;
//    }
//
//    public void addVehicle(Vehicle vehicle) {
//        this.inventory.add(vehicle);
//    }
//
//    public void removeVehicle(Vehicle vehicle) {
//        this.inventory.remove(vehicle);
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//}