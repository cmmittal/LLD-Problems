package ParkingLot.src.main.java.strategy;

import java.util.List;

import ParkingLot.src.main.java.entity.Floor;
import ParkingLot.src.main.java.entity.ParkingSpot;
import ParkingLot.src.main.java.entity.VehicleType;
import ParkingLot.src.main.java.repository.FloorRepository;

public class BikeParkingStrategy implements ParkingStrategy{

    VehicleType bike = VehicleType.BIKE;
    VehicleType car = VehicleType.CAR;
    VehicleType truck = VehicleType.TRUCK;
    int bikeSize = 1;

    public void park(int spotId){

        for (Floor floor : FloorRepository.floorList){
            List<ParkingSpot> spots = floor.spots;

            for (ParkingSpot spot : spots) {
                if (spot.id == spotId) {
                    spot.occupancy += bikeSize;
                    System.out.println("Bike Parked Successfully\n");
                    return;
                }
            }
        }
    }

    public int getParking(){
        for (Floor floor : FloorRepository.floorList) {
            List<ParkingSpot> spots = floor.spots;

            for (ParkingSpot parkingSpot : spots) {
                if (parkingSpot.type.equals(bike) && parkingSpot.occupancy == 0) {
                    System.out.println("Parking Spot available at " + parkingSpot.id);
                    return parkingSpot.id;
                }
            }
        }

        for (Floor floor : FloorRepository.floorList) {
            List<ParkingSpot> spots = floor.spots;

            for (ParkingSpot parkingSpot : spots) {
                if (parkingSpot.type.equals(car) && parkingSpot.occupancy <= 1) {
                    System.out.println("Parking Spot available at " + parkingSpot.id);
                    return parkingSpot.id;
                }
            }
        }

        for (Floor floor : FloorRepository.floorList) {
            List<ParkingSpot> spots = floor.spots;

            for (ParkingSpot parkingSpot : spots) {
                if (parkingSpot.type.equals(truck) && parkingSpot.occupancy <= 1){
                    System.out.println("Parking Spot available at " + parkingSpot.id);
                    return parkingSpot.id;
                }
            }
        }

        System.out.println("No Parking Spot available\n");
        return -1;
    }
}
