package ParkingLot.src.main.java.factory;

import ParkingLot.src.main.java.entity.VehicleType;
import ParkingLot.src.main.java.strategy.BikeParkingStrategy;
import ParkingLot.src.main.java.strategy.CarParkingStrategy;
import ParkingLot.src.main.java.strategy.ParkingStrategy;
import ParkingLot.src.main.java.strategy.TruckParkingStrategy;

public class ParkingFactory {

    public ParkingStrategy getParkingStrategy(VehicleType vehicleType){
        if (vehicleType.equals(VehicleType.CAR)) {
            return new CarParkingStrategy();
        }
        else if (vehicleType.equals(VehicleType.BIKE)) {
            return new BikeParkingStrategy();
        }
        else{
            return new TruckParkingStrategy();
        }
    }
}
