package ParkingLot.src.main.java.strategy;

import java.util.List;

import ParkingLot.src.main.java.entity.Floor;
import ParkingLot.src.main.java.entity.ParkingSpot;
import ParkingLot.src.main.java.entity.VehicleType;
import ParkingLot.src.main.java.repository.FloorRepository;

public class CarParkingStrategy implements ParkingStrategy {

    VehicleType car = VehicleType.CAR;
    VehicleType truck = VehicleType.TRUCK;
    int carSize = 2;

    public void park(int spotId){

        for (Floor floor : FloorRepository.floorList){
            List<ParkingSpot> spots = floor.spots;

            for (ParkingSpot spot : spots) {
                if (spot.id == spotId) {
                    spot.occupancy += carSize;
                    System.out.println("Car Parked Successfully\n");
                    return;
                }
            }
        }
    }

    public int getParking(){

        for (Floor floor : FloorRepository.floorList) {
            List<ParkingSpot> spots = floor.spots;

            for (ParkingSpot parkingSpot : spots) {
                if (parkingSpot.type.equals(car) && parkingSpot.occupancy == 0) {
                    System.out.println("Parking Spot available at " + parkingSpot.id + " Type " + parkingSpot.type);
                    return parkingSpot.id;
                }
            }
        }

        for (Floor floor : FloorRepository.floorList) {
            List<ParkingSpot> spots = floor.spots;

            for (ParkingSpot parkingSpot : spots) {
                if (parkingSpot.type.equals(truck) && parkingSpot.occupancy <= 2) {
                    System.out.println("Parking Spot available at " + parkingSpot.id + " Type " + parkingSpot.type);
                    return parkingSpot.id;
                }
            }
        }

        System.out.println("No Parking Spot available\n");
        return -1;
    }
}
