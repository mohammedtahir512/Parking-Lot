package com.task2_parkinglot;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<ParkingLot> parkingLotArrayList = new ArrayList<ParkingLot>();
     static Admin admin = new Admin("","");

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       System.out.println("Choose an option:");
        while (true) {
            System.out.println("0. To create an Admin or User");
            System.out.println("1. To initialize a parking lot");
            System.out.println("2. To Login");
            System.out.println("3. To Give Access To User");
            System.out.println("4. To Get all details of Parking Lot");
            System.out.println("5. To exit");

            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    System.out.println("Enter 1: Create Admin");
                    System.out.println("Enter 2: Create User");
                    int choice= scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter Admin name ");
                            String name = scanner.next();
                            scanner.nextLine();

                            System.out.println("Enter password (it should contain atleast 1 uppercase char, 1 lowercase char, 1 special char, 1 num)");
                            String password = scanner.next();
                            scanner.nextLine();

                            Admin admin = new Admin(name, password);
                            admin.signUp(name, password);
                            break;
                        case 2:
                            System.out.println("Enter User name ");
                            String name1 = scanner.next();
                            scanner.nextLine();
                            System.out.println("Enter password (it should contain atleast 1 uppercase char, 1 lowercase char, 1 special char, 1 num)");
                            String password1 = scanner.next();
                            scanner.nextLine();
                            User user = new User(name1, password1);
                            user.signUp(name1, password1);
                            break;
                    }
                    break;



                case 1:
                    if (admin == null) {
                        System.out.println("Admin not initialized yet. Please create an Admin first.");
                        break;
                    }

                    System.out.println("To create a ParkingLot, enter the number of floors ");
                    int numOfFloors = scanner.nextInt();

                    for (int i = 0; i < numOfFloors; i++) {
                        System.out.println("Enter the number of slots for TwoWheeler, FourWheeler, HeavyVehicle for Floor "
                                + (i + 1));
                        int[] slots = new int[3];
                        for (int j = 0; j < slots.length; j++) {
                            slots[j] = scanner.nextInt();
                        }
                        parkingLotArrayList.add(new ParkingLot(slots[0], slots[1], slots[2]));
                    }
                    System.out.println("Parking has been initialized.");
                    break;

                case 2:
                    if (admin == null) {
                        System.out.println("Admin not initialized yet. Please create an Admin first.");
                        break;
                    }

                    System.out.println("Enter user name");
                    String name1 = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter password");
                    String password1 = scanner.nextLine();
                    admin.getUserAuthenticationSystem().signUp(name1,password1);
                    break;

                case 3:
                    if (parkingLotArrayList.isEmpty() || admin.getAdminName().isEmpty()) {
                        System.out.println("No parking lot initialized yet or Admin not created.");
                    } else {
                        if (admin.getAdminName().isEmpty()) {


                            System.out.println("Create Admin");
                            System.out.println("Enter Admin name");
                            String userName = scanner.next();
                            scanner.nextLine();
                            admin.setAdminName(userName);

                            System.out.println("Enter password");
                            String userPassword = scanner.nextLine();
                            admin.getUserAuthenticationSystem().signUp(userName,userPassword);
                        }


                        User.UserMain(parkingLotArrayList);
                    }
                    break;


                case 4:
                    for (int i = 0; i < parkingLotArrayList.size(); i++) {
                        String occupiedSlotsDetails = parkingLotArrayList.get(i).getOccupiedSlotsDetails();

                        System.out.println(occupiedSlotsDetails);
                        System.out.println(parkingLotArrayList.get(i).currentAvailableSlots());
                    }
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}


