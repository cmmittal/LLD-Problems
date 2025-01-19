package ParkingLot.src.main.java.service;


import ParkingLot.src.main.java.entity.*;
import ParkingLot.src.main.java.factory.ParkingFactory;
import ParkingLot.src.main.java.strategy.ParkingStrategy;

public class ParkingLot {

    FloorService floorService = new FloorService();
    ParkingFactory parkingFactory = new ParkingFactory();


    public int getParking(VehicleType vehicleType){

        ParkingStrategy parkingStrategy = parkingFactory.getParkingStrategy(vehicleType);

        return parkingStrategy.getParking();    
    }
}
