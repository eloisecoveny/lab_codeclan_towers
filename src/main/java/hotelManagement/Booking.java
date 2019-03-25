package hotelManagement;

import rooms.Bedroom;

public class Booking {

    private Bedroom bedroom;
    private int nights;

    public Booking(Bedroom bedroom, int nights){
        this.bedroom = bedroom;
        this.nights = nights;
    }

    public Bedroom getBedroom(){
        return this.bedroom;
    }

    public int getNights(){
        return this.nights;
    }

    public double getBill(){
        return this.bedroom.getPrice() * this.nights;
    }
}
