package ParkingLot.src.main.java.service;

import ParkingLot.src.main.java.entity.ParkingSpot;
import ParkingLot.src.main.java.repository.SpotRepository;

public class FloorService {

    public void park(int spotId, int size){

        for (ParkingSpot spot : SpotRepository.spotList) {
            if (spot.id == spotId) {
                spot.occupancy += size;
                System.out.println("Vehicle Parked Successfully");
                return;
            }
        }
    }

    public void unPark(int spotId, int size){
        
        for (ParkingSpot spot : SpotRepository.spotList) {
            if (spot.id == spotId) {
                spot.occupancy -= size;
                System.out.println("Vehicle Un-Parked successfully");
                return;
            }
        }
    }
}
