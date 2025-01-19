package ParkingLot.src.main.java.strategy;

import java.util.List;

import ParkingLot.src.main.java.entity.Floor;
import ParkingLot.src.main.java.entity.ParkingSpot;
import ParkingLot.src.main.java.entity.VehicleType;
import ParkingLot.src.main.java.repository.FloorRepository;

public class TruckParkingStrategy implements ParkingStrategy{

    VehicleType truck = VehicleType.TRUCK;
    int truckSize = 4;

    public void park(int spotId){

        for (Floor floor : FloorRepository.floorList) {
            List<ParkingSpot> spots = floor.spots;
            
            for (ParkingSpot spot : spots) {
                if (spot.id == spotId) {
                    spot.occupancy += truckSize;
                    System.out.println("Truck Parked Successfully\n");
                    return;
                }
            }
        }
    }

    public int getParking(){
        for (Floor floor : FloorRepository.floorList) {
            List<ParkingSpot> spots = floor.spots;

            for (ParkingSpot parkingSpot : spots) {
                if (parkingSpot.type.equals(truck) && parkingSpot.occupancy == 0) {
                    System.out.println("Parking Spot available at " + parkingSpot.id);
                    return parkingSpot.id;
                }
            }
        }

        System.out.println("No Parking Spot available\n");
        return -1;
    }
}
