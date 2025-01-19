package ParkingLot.src.main.java.entity;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Floor {

    private static AtomicInteger count = new AtomicInteger(0);
    public List<ParkingSpot> spots;
    int floorId;

    public Floor(List<ParkingSpot> spots){
        this.spots = spots;
        this.floorId = count.incrementAndGet();
    }
}
