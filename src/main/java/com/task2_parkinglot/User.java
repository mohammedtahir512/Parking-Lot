package com.task2_parkinglot;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public  class User extends UserAuthenticationSystem {
    private  String userName;
    private  String password;

    public User(String userName, String password ){
        this.userName=userName;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void UserMain(ArrayList<ParkingLot> parkingLotArrayList) {
        User user=new User("","");
        while (true) {
            System.out.println(" 0. To sign Up");
            System.out.println("\n1. Park Vehicle");
            System.out.println("2. Unpark Vehicle");
            System.out.println("3. To Access Admin");
            System.out.println("4. To exit ");
            System.out.print("Enter your choice: ");
            Scanner scanner= new Scanner(System.in);
            String choice = scanner.nextLine();


            switch (choice) {
                case "0":


                    System.out.println("enter user name");
                    String name = scanner.next();
                    scanner.nextLine();
                    user.setUserName(name);
                    System.out.println("enter password");
                    String password = scanner.nextLine();
                    user.getUserAuthenticationSystem().signUp(name,password);
                    break;


                case "1":
                    if (parkingLotArrayList.isEmpty()) System.out.println("no parkinglot initilized yet");
                    try {
                        System.out.print("Enter vehicle number: ");
                        String number = scanner.nextLine();
                    } catch (InputMismatchException e) {

                        System.out.print("Enter the correct inputType");

                    }
                    System.out.print("Enter vehicle Type (2W/4W/HV): ");
                    String vehicleType = scanner.nextLine();
                    Vehicle vehicle = new Vehicle("4664", "2W");

                    if (!Vehicle.isValidVehicleType(vehicleType)) {
                        System.out.println("Invalid vehicle type. Please enter 2W, 4W, or HV.");

                    } else {
                        vehicle.setVehicleType(vehicleType);
                    }
                    int floorNo = -1;
                    System.out.println("enter the floor no");
                        floorNo = scanner.nextInt();
                        if (floorNo > parkingLotArrayList.size() - 1) {
                            System.out.println(" floor No does not exist");
                            user.UserMain(parkingLotArrayList);
                        }



                    int slotNumber = -1;
                    slotNumber = parkingLotArrayList.get(floorNo).parkVehicle(vehicle);
                    if (slotNumber != -1) {
                        System.out.println("Vehicle parked successfully. Slot number: " + slotNumber);

                        //generating ticket
                        LocalDateTime inTime = LocalDateTime.now();
                        //LocalDateTime outTime=LocalDateTime.now().plusMinutes(60);
                        Ticket.getTicket(vehicle, parkingLotArrayList, slotNumber, floorNo, inTime, inTime);

                    } else {
                        System.out.println("No available slots for this vehicle type.");
                    }
                    break;

                case "2":

                        System.out.println(("checking if user has parked the vehicle"));
                        System.out.println("enter user name");
                        String name1 = scanner.next();
                        scanner.nextLine();
                        System.out.println("enter password");
                        String password1 = scanner.nextLine();
                        user.getUserAuthenticationSystem().signIn(name1,password1);




                        System.out.println("Enter floor  number to unpark: ");
                        int floorNo1 = scanner.nextInt();
                    System.out.println("enter the slot number");
                    int slotNum=scanner.nextInt();
                        Vehicle unparkedVehicle = parkingLotArrayList.get(floorNo1).unparkVehicle(slotNum);
                        if (unparkedVehicle != null) {
                            System.out.println("Vehicle with number " + unparkedVehicle.getNumber() + " unparked from slot " + slotNum);

                            //print unparking time
                            LocalDateTime outTime = LocalDateTime.now();
                            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                            String formattedOutTime = outTime.format(format);
                            System.out.println("the unparking time is " + formattedOutTime);
                        } else {
                            System.out.println("Slot is empty or invalid slot number.");
                        }

                    break;

                case "3":
                    System.out.println("Giving Access to Admin");
                    return;
                case "4":
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }


}


