package rooms;

import customer.Guest;

import java.util.ArrayList;

public class DiningRoom extends Room {

    private String name;
    private int capacity;
    private int pricePerEvent;
    private ArrayList<Guest> guests;

    public DiningRoom(String name, int capacity, int pricePerEvent){
        super(name, capacity, pricePerEvent);
    }

}
