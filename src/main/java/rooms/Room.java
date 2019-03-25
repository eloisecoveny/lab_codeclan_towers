package rooms;

import customer.Guest;
import hotelManagement.Booking;

import java.util.ArrayList;

public abstract class Room {

    private String identifier;
    private int capacity;
    private double price;
    private ArrayList<Guest> guests;
    private Boolean occupied;
    private Booking booking;

    public Room(String identifier, int capacity, double price){
        this.identifier = identifier;
        this.capacity = capacity;
        this.price = price;
        this.guests = new ArrayList<Guest>();
        this.occupied = false;
        this.booking = booking;
    }

    public String getIdentifier(){
        return identifier;
    }

    public int getCapacity(){
        return capacity;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public ArrayList<Guest> getGuests(){
        return guests;
    }

    public int countGuests(){
        return guests.size();
    }

    public void add(Guest guest){
        this.guests.add(guest);
        guest.checkIn();
    }

    public void remove(Guest guest){
        guest.checkOut();
        int index = this.guests.indexOf(guest);
        this.guests.remove(index);
    }

    public void addBooking(Booking booking){
        this.booking = booking;
    }

    public Boolean isOccupied(){
        return this.occupied;
    }

    public void occupy(){
        this.occupied = true;
    }

    public void unoccupy(){
        this.occupied = false;
    }

    public double getBill(){
        return this.booking.getBill();
    }
}
