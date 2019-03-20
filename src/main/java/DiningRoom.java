import java.util.ArrayList;

public class DiningRoom {

    private String name;
    private int capacity;
    private int pricePerEvent;
    private ArrayList<Guest> guests;

    public DiningRoom(String name, int capacity, int pricePerEvent){
        this.name = name;
        this.capacity = capacity;
        this.pricePerEvent = pricePerEvent;
        this.guests = new ArrayList<Guest>();
    }

    public String getName(){
        return this.name;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int getRate(){
        return this.pricePerEvent;
    }

    public int countGuests(){
        return this.guests.size();
    }

    public void add(Guest guest){
        this.guests.add(guest);
        guest.checkIn();
    }

    public ArrayList<Guest> getGuests(){
        return guests;
    }

    public void remove(Guest guest){
        guest.checkOut();
        int index = this.guests.indexOf(guest);
        this.guests.remove(index);
    }
}
