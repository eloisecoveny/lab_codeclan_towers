package hotelManagement;

import customer.Guest;
import rooms.Bedroom;
import rooms.ConferenceRoom;
import rooms.DiningRoom;

import java.util.ArrayList;

public class Hotel {

    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<DiningRoom> diningRooms;
    private ArrayList<Booking> bookings;

    public Hotel(String name){
        this.name = name;
        this.bedrooms = new ArrayList<Bedroom>();
        this.conferenceRooms = new ArrayList<ConferenceRoom>();
        this.diningRooms = new ArrayList<DiningRoom>();
        this.bookings = new ArrayList<Booking>();
    }

    public String getName(){
        return this.name;
    }

    public int countBedrooms(){
        return this.bedrooms.size();
    }

    public int countConferenceRooms(){
        return this.conferenceRooms.size();
    }

    public int countDiningRooms(){
        return this.diningRooms.size();
    }

    public int countBookings(){
        return this.bookings.size();
    }

    public void addBedroom(Bedroom bedroom){
        this.bedrooms.add(bedroom);
    }

    public void addConferenceRoom(ConferenceRoom conferenceRoom){
        this.conferenceRooms.add(conferenceRoom);
    }

    public void addDiningRoom(DiningRoom diningRoom){
        this.diningRooms.add(diningRoom);
    }


    public void bookRoom(Bedroom bedroom, Guest guest, int nights){
        Booking booking = null;
        if(!bedroom.isOccupied() && bedroom.countGuests() <  bedroom.getCapacity()){
            bedroom.add(guest);
            booking = new Booking(bedroom, nights);
            this.bookings.add(booking);
        }
        bedroom.addBooking(booking);
    }

    public void makeConferenceRoomBooking(ConferenceRoom conferenceRoom, Guest guest){
        conferenceRoom.add(guest);
    }

    public void makeDiningRoomBooking(DiningRoom diningRoom, Guest guest){
        diningRoom.add(guest);
    }

    public void checkGuestsOutOfBedroom(Bedroom bedroom){
        ArrayList<Guest> guests = bedroom.getGuests();
        int noGuests = guests.size();
        for(int i = 0; i < noGuests; i++){
            bedroom.remove(guests.get(0));
            bedroom.unoccupy();
        }
    }

    public void checkGuestsOutOfConferenceRoom(ConferenceRoom conferenceRoom){
        ArrayList<Guest> guests = conferenceRoom.getGuests();
        int noGuests = guests.size();
        for(int i = 0; i < noGuests; i++){
            conferenceRoom.remove(guests.get(0));
            conferenceRoom.unoccupy();
        }
    }

    public void checkGuestsOutOfDiningRoom(DiningRoom diningRoom){
        ArrayList<Guest> guests = diningRoom.getGuests();
        int noGuests = guests.size();
        for(int i = 0; i < noGuests; i++){
            diningRoom.remove(guests.get(0));
            diningRoom.unoccupy();
        }
    }

    public ArrayList<Booking> getBookings(){
        return this.bookings;
    }

    public ArrayList<Bedroom> vacantRooms(){
        ArrayList<Bedroom> vacantRooms = new ArrayList<Bedroom>();
        for(int i = 0; i < this.bedrooms.size(); i++){
            if(this.bedrooms.get(i).getGuests().size() == 0){
                vacantRooms.add(bedrooms.get(i));
            }
        }
        return vacantRooms;

//        ArrayList<rooms.Bedroom> vacantRooms = new ArrayList<rooms.Bedroom>();
//        for(rooms.Bedroom bedroom : this.bedrooms){
//            if(bedroom.getGuests().size() == 0){
//                vacantRooms.add(bedroom);
//            }
//        }
//        return vacantRooms;
    }
}
