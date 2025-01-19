package ParkingLot.src.main.java.service;

import java.util.List;

import ParkingLot.src.main.java.entity.*;
import ParkingLot.src.main.java.repository.FloorRepository;

public class ParkingLot {

    FloorService floorService = new FloorService();


    public int getParking(VehicleType vehicleType){
        
        for (Floor floor : FloorRepository.floorList) {
            List<ParkingSpot> spots = floor.spots;

            for (ParkingSpot parkingSpot : spots) {
                if (parkingSpot.type.equals(vehicleType) && parkingSpot.occupancy == 0) {
                    System.out.println("Parking Spot available at " + parkingSpot.id);
                    return parkingSpot.id;
                }
            }
        }

        System.out.println("No Parking Spot available");
        return -1;
    }
}
