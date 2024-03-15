package com.task2_parkinglot;

import java.util.ArrayList;

public class Admin extends UserAuthenticationSystem{
    private ArrayList<ParkingLot> parkingLotArrayList;
    private int id;
    private String adminName;
    private String password;
    private User user;

    public Admin(String s, String string) {
        adminName = " ";
        password = " ";
    }

    public User getUser() {
        return user;
    }

    public Admin(ArrayList parkingLotArrayList, String adminName, String password) {
        this.parkingLotArrayList = parkingLotArrayList;
        this.adminName = adminName;
        this.password = password;
    }

    public ArrayList<ParkingLot> getParkingLot() {
        return parkingLotArrayList;
    }

    public int getId() {
        return id;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setParkingLot(ArrayList<ParkingLot> parkingLotArrayList) {
        this.parkingLotArrayList = parkingLotArrayList;
    }



    public void setUser(User user) {
        this.user = user;
    }

    // ParkingLot parkingLot=new ParkingLot(10,10,5);

    public static boolean checkPasswordFormat(String str) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                numberFlag = true;
            } else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if (numberFlag && capitalFlag && lowerCaseFlag)
                return true;
        }
        return false;
    }
}
