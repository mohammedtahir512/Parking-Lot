package com.task2_parkinglot;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;


public class Ticket {
    private int floorNo;
    private long ticketNo;
    private  Vehicle vehicle;
    private ParkingLot parkingLot;
    private int slotNumber;
    private LocalDateTime inTime;
    private LocalDateTime outTime;


    public Ticket(int ticketNo,Vehicle vehicle,ParkingLot parkingLot,int slotNumber,int floorNo,LocalDateTime inTime,LocalDateTime outTime){
        this.ticketNo= ticketNo;
        this.vehicle=vehicle;
        this.slotNumber=parkingLot.parkVehicle(vehicle);
        this.parkingLot=parkingLot;
        this.inTime=inTime;
        this.outTime=inTime.plusMinutes(60);
        this.floorNo=-1;



    }


    public static void getTicket(Vehicle vehicle, ArrayList<ParkingLot> parkingLot, int slotNumber, int floorNo, LocalDateTime inTime, LocalDateTime outTime){
        System.out.println("Ticket Details: ");

        Random random = new Random();
        int number = random.nextInt();
        System.out.println("Ticket number: "+number);
        for (int i = 0; i < Main.parkingLotArrayList.size(); i++) {
            floorNo = Main.parkingLotArrayList.get(i).getNextAvailableSlot(vehicle.getvehicleType());
        }
        System.out.println("Park your vehicle in: "+floorNo);;
        System.out.println("Vehicle No: "+vehicle.getNumber());
        System.out.println("Floor Number: "+floorNo);
        System.out.println("slot number: "+ slotNumber);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedInTime = inTime.format(format);
        String formattedOutTime= inTime.plusMinutes(60).format((format));

        System.out.println("Entry Time: "+formattedInTime );
        System.out.println("Exit Time: "+formattedOutTime );

        return ;
    }

}
