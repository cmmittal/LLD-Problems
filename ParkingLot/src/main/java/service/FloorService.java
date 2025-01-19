package ParkingLot.src.main.java.service;

import ParkingLot.src.main.java.entity.VehicleType;
import ParkingLot.src.main.java.factory.ParkingFactory;
import ParkingLot.src.main.java.strategy.ParkingStrategy;

public class FloorService {

    ParkingFactory parkingFactory = new ParkingFactory();

    public void park(int spotId, VehicleType vehicleType){

        ParkingStrategy parkingStrategy = parkingFactory.getParkingStrategy(vehicleType);

        parkingStrategy.park(spotId);
    }

    public void unPark(int spotId, int size){
        // TODO
    }
}
