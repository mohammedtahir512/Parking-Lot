package com.task2_parkinglot;


public class Vehicle {

    private String number;
    private String vehicleType;

    public Vehicle(String number, String vehicleType) {
        this.number = number;
        this.vehicleType = vehicleType;
    }

    public String getvehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getNumber() {
        // TODO Auto-generated method stub
        return number;
    }
    public static boolean isValidVehicleType(String type) {
        return type.equals("2W") || type.equals("4W") || type.equals("HV");
    }

}


