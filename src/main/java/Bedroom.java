import java.util.ArrayList;

public class Bedroom {

    private int roomNo;
    private int capacity;
    private String type;
    private int pricePerNight;
    private ArrayList<Guest> guests;

    public Bedroom(int roomNo, int capacity, String type, int pricePerNight){
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.guests = new ArrayList<Guest>();
    }

    public int getRoomNo(){
        return this.roomNo;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public int countGuests(){
        return this.guests.size();
    }

    public String getType(){
        return this.type;
    }

    public int getPrice(){
        return this.pricePerNight;
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
