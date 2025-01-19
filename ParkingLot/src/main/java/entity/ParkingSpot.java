package ParkingLot.src.main.java.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class ParkingSpot {

    private static AtomicInteger count = new AtomicInteger(0);
    public int id;
    public VehicleType type;
    public int occupancy;

    public ParkingSpot(VehicleType type){
        this.id = count.incrementAndGet();
        this.type = type;
        this.occupancy = 0;
    }
}
