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

        SpotRepository.spotList.addAll(list1);
        SpotRepository.spotList.addAll(list2);
        SpotRepository.spotList.addAll(list3);


        int spotId = parkingLot.getParking(VehicleType.CAR);
        floorService.park(spotId, 2);

        int spotId2 = parkingLot.getParking(VehicleType.BIKE);
        floorService.park(spotId2, 1);
    }
}
