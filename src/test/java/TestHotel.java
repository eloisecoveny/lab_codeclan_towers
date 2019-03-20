import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestHotel {

    public Hotel hotel;
    public Guest guest1;
    public Guest guest2;
    public Bedroom bedroom1;
    public ConferenceRoom conferenceRoom1;
    public DiningRoom diningRoom1;

    @Before
    public void setup(){
        hotel = new Hotel("CodeClan Towers");
        guest1 = new Guest("Eloise", "eloisecoveny@gmail.com", false);
        guest2 = new Guest("Alice", "alice@gmail.com", false);
        bedroom1 = new Bedroom(1, 2, "double", 85);
        conferenceRoom1 = new ConferenceRoom("Desert room", 150, 85);
        diningRoom1 = new DiningRoom("Bassey room", 50, 150);
    }

    @Test
    public void hotelHasName(){
        assertEquals("CodeClan Towers", hotel.getName());
    }

    @Test
    public void hotelStartsWithNoBedrooms(){
        assertEquals(0, hotel.countBedrooms());
    }

    @Test
    public void hotelStartsWithNoConferenceRooms(){
        assertEquals(0, hotel.countConferenceRooms());
    }

    @Test
    public void hotelStartsWithNoDiningRooms(){
        assertEquals(0, hotel.countDiningRooms());
    }

    @Test
    public void hotelStartsWithNoBookings(){
        assertEquals(0, hotel.countBookings());
    }

    @Test
    public void canAddBedroomToHotel(){
        hotel.addBedroom(bedroom1);
        assertEquals(1, hotel.countBedrooms());
    }

    @Test
    public void canAddConferenceRoomToHotel(){
        hotel.addConferenceRoom(conferenceRoom1);
        assertEquals(1, hotel.countConferenceRooms());
    }

    @Test
    public void canAddDiningRoomToHotel(){
        hotel.addDiningRoom(diningRoom1);
        assertEquals(1, hotel.countDiningRooms());
    }

    @Test
    public void hotelCanCheckGuestIntoBedroom(){
        hotel.makeBedroomBooking(bedroom1, guest1);
        assertEquals(1, bedroom1.countGuests());
        assertEquals(true, guest1.isCheckedIn());
    }

    @Test
    public void hotelCanCheckMultipleGuestsIntoBedroom(){
        hotel.makeBedroomBooking(bedroom1, guest1);
        hotel.makeBedroomBooking(bedroom1, guest2);
        assertEquals(2, bedroom1.countGuests());
        assertEquals(true, guest1.isCheckedIn());
        assertEquals(true, guest2.isCheckedIn());
    }

    @Test
    public void hotelCanCheckMultipleGuestsOutOfBedroom(){
        hotel.makeBedroomBooking(bedroom1, guest1);
        hotel.makeBedroomBooking(bedroom1, guest2);
        hotel.checkGuestsOutOfBedroom(bedroom1);
        assertEquals(0, bedroom1.countGuests());
        assertEquals(false, guest1.isCheckedIn());
        assertEquals(false, guest2.isCheckedIn());
    }

    @Test
    public void hotelCanCheckGuestIntoConferenceRoom(){
        hotel.makeConferenceRoomBooking(conferenceRoom1, guest1);
        assertEquals(1, conferenceRoom1.countGuests());
        assertEquals(true, guest1.isCheckedIn());
    }

    @Test
    public void hotelCanCheckMultipleGuestsOutOfConferenceRoom(){
        hotel.makeConferenceRoomBooking(conferenceRoom1, guest1);
        hotel.makeConferenceRoomBooking(conferenceRoom1, guest2);
        hotel.checkGuestsOutOfConferenceRoom(conferenceRoom1);
        assertEquals(0, conferenceRoom1.countGuests());
        assertEquals(false, guest1.isCheckedIn());
        assertEquals(false, guest2.isCheckedIn());
    }

    @Test
    public void hotelCanCheckGuestIntoDiningRoom(){
        hotel.makeDiningRoomBooking(diningRoom1, guest1);
        assertEquals(1, diningRoom1.countGuests());
        assertEquals(true, guest1.isCheckedIn());
    }

    @Test
    public void hotelCanCheckMultipleGuestsOutOfDiningRoom(){
        hotel.makeDiningRoomBooking(diningRoom1, guest1);
        hotel.makeDiningRoomBooking(diningRoom1, guest2);
        hotel.checkGuestsOutOfDiningRoom(diningRoom1);
        assertEquals(0, diningRoom1.countGuests());
        assertEquals(false, guest1.isCheckedIn());
        assertEquals(false, guest2.isCheckedIn());
    }

}
