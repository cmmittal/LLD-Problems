package ParkingLot.src.main.java;

import java.util.Arrays;
import java.util.List;

import ParkingLot.src.main.java.entity.*;
import ParkingLot.src.main.java.service.FloorService;
import ParkingLot.src.main.java.service.ParkingLot;
import ParkingLot.src.main.java.repository.*;

public class App {

    static ParkingLot parkingLot = new ParkingLot();
    static FloorService floorService = new FloorService();

    public static void main(String[] args) {
        ParkingSpot spot1 = new ParkingSpot(VehicleType.CAR);
        ParkingSpot spot2 = new ParkingSpot(VehicleType.CAR);
        ParkingSpot spot3 = new ParkingSpot(VehicleType.CAR);
        ParkingSpot spot4 = new ParkingSpot(VehicleType.CAR);
        ParkingSpot spot5 = new ParkingSpot(VehicleType.CAR);
    
        ParkingSpot spot6 = new ParkingSpot(VehicleType.BIKE);
        ParkingSpot spot7 = new ParkingSpot(VehicleType.BIKE);
        ParkingSpot spot8 = new ParkingSpot(VehicleType.BIKE);
        ParkingSpot spot9 = new ParkingSpot(VehicleType.BIKE);
        ParkingSpot spot10 = new ParkingSpot(VehicleType.BIKE);
    
        ParkingSpot spot11 = new ParkingSpot(VehicleType.TRUCK);
        ParkingSpot spot12 = new ParkingSpot(VehicleType.TRUCK);
    
        List<ParkingSpot> list1 = Arrays.asList(spot1, spot2, spot6, spot7, spot11);
        List<ParkingSpot> list2 = Arrays.asList(spot3, spot4, spot8, spot9, spot12);
        List<ParkingSpot> list3 = Arrays.asList(spot5, spot10);
    
        Floor floor1 = new Floor(list1);
        Floor floor2 = new Floor(list2);
        Floor floor3 = new Floor(list3);

        FloorRepository.floorList.add(floor1);
        FloorRepository.floorList.add(floor2);
        FloorRepository.floorList.add(floor3);


        int spotId1 = parkingLot.getParking(VehicleType.CAR);
        floorService.park(spotId1, VehicleType.CAR);

        int spotId2 = parkingLot.getParking(VehicleType.BIKE);
        floorService.park(spotId2, VehicleType.BIKE);

        int spotId3 = parkingLot.getParking(VehicleType.CAR);
        floorService.park(spotId3, VehicleType.CAR);

        int spotId4 = parkingLot.getParking(VehicleType.CAR);
        floorService.park(spotId4, VehicleType.CAR);

        int spotId5 = parkingLot.getParking(VehicleType.CAR);
        floorService.park(spotId5, VehicleType.CAR);

        int spotId6 = parkingLot.getParking(VehicleType.CAR);
        floorService.park(spotId6, VehicleType.CAR);

        int spotId7 = parkingLot.getParking(VehicleType.CAR);
        floorService.park(spotId7, VehicleType.CAR);

        int spotId8 = parkingLot.getParking(VehicleType.TRUCK);
        floorService.park(spotId8, VehicleType.TRUCK);

        int spotId9 = parkingLot.getParking(VehicleType.TRUCK);
        floorService.park(spotId9, VehicleType.TRUCK);

        int spotId10 = parkingLot.getParking(VehicleType.CAR);
        floorService.park(spotId10, VehicleType.CAR);

        int spotId11 = parkingLot.getParking(VehicleType.CAR);
        floorService.park(spotId11, VehicleType.CAR);
    }
}
