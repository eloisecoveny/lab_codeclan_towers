package rooms;

import customer.Guest;

import java.util.ArrayList;

public class Bedroom extends Room{

    private BedroomType type;

    public Bedroom(String identifier, int capacity, BedroomType type, double pricePerNight){
        super(identifier, capacity, pricePerNight);
        this.type = type;
    }

    public BedroomType getType(){
        return this.type;
    }

}
