package com.task2_parkinglot;






import java.util.HashMap;
import java.util.Map;


public class ParkingLot {
     private  int floorNo;
    private int numOf2WheeleerSlots;
    private int numOf4WheeleerSlots;
    private int numOfHeavyVehicleSlots;
    private int available2WheelerSlots;
    private int available4WheelerSlots;
    private int availableHeavyVehicleSlots;
    private Map<Integer,Vehicle> occupiedSlots;
    private Ticket ticket;
    private Vehicle vehicle;





    public int getAvailable2WheelerSlots() {
        return available2WheelerSlots;
    }

    public int getAvailable4WheelerSlots() {
        return available4WheelerSlots;
    }

    public int getAvailableHeavyVehicleSlots() {
        return availableHeavyVehicleSlots;
    }

    public ParkingLot(int numOf2WheelerSlots, int numOf4WheelerSlots, int numOfHeavyVehicleSlots) {
        this.numOf2WheeleerSlots = numOf2WheelerSlots;
        this.numOf4WheeleerSlots = numOf4WheelerSlots;
        this.numOfHeavyVehicleSlots = numOfHeavyVehicleSlots;
        this.available2WheelerSlots = numOf2WheelerSlots;
        this.available4WheelerSlots = numOf4WheelerSlots;
        this.availableHeavyVehicleSlots = numOfHeavyVehicleSlots;
        this.occupiedSlots = new HashMap<>();
    }



    public int getNextAvailableSlot(String size) {
        int slotNumber = 1;
        while (occupiedSlots.containsKey(slotNumber)) {
            slotNumber++;
        }
        return slotNumber;
    }


    public int parkVehicle(Vehicle vehicle) {
        int slotNumber = -1;
        if (vehicle.getvehicleType().equals("2W")) {
            if (available2WheelerSlots > 0) {
                slotNumber = getNextAvailableSlot("2W");
                available2WheelerSlots--;
                occupiedSlots.put(slotNumber, vehicle);
            }
        } else if (vehicle.getvehicleType().equals("4W")) {
            if (available4WheelerSlots > 0) {
                slotNumber = getNextAvailableSlot("4W");
                available4WheelerSlots--;
                occupiedSlots.put(slotNumber, vehicle);
            }
        } else if (vehicle.getvehicleType().equals("HV")) {
            if (availableHeavyVehicleSlots > 0) {
                slotNumber = getNextAvailableSlot("HV");
                availableHeavyVehicleSlots--;
                occupiedSlots.put(slotNumber, vehicle);
            }
        }
        return slotNumber;
    }

    public Vehicle unparkVehicle(int slotNumber) {

        if (occupiedSlots.containsKey(slotNumber)) {
            vehicle = occupiedSlots.remove(slotNumber);
            String vehicleType = vehicle.getvehicleType();
            if (vehicleType.equals("2W")) {
                available2WheelerSlots++;
            } else if (vehicleType.equals("4W")) {
                available4WheelerSlots++;
            } else if (vehicleType.equals("HV")) {
                availableHeavyVehicleSlots++;
            }
        }
        return vehicle;
    }

    public String currentAvailableSlots() {

        String ans= "2 Wheeler Slots: " + available2WheelerSlots + "/" + numOf2WheeleerSlots + ", 4 Wheeler Slots: "
                + available4WheelerSlots + "/" + numOf4WheeleerSlots + ", Heavy Vehicle Slots: " + availableHeavyVehicleSlots
                + "/" + numOfHeavyVehicleSlots;
        return ans.toString();

    }

    public String getOccupiedSlotsDetails() {
        StringBuilder details = new StringBuilder("Occupied Slots Details:\n");

        for (Map.Entry<Integer, Vehicle> entry : occupiedSlots.entrySet()) {
            int slotNumber = entry.getKey();
            Vehicle vehicle = entry.getValue();
            String vehicleType = vehicle.getvehicleType();
            details.append("Slot ").append(slotNumber).append(": ").append(vehicleType).append("\n");
        }



        return details.toString();
    }



}
