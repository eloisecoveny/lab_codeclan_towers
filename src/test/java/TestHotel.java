import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestHotel {

    public Hotel hotel;
    public Guest guest1;
    public Guest guest2;
    public Bedroom bedroom1;
    public Bedroom bedroom2;
    public ConferenceRoom conferenceRoom1;
    public DiningRoom diningRoom1;
    public Booking booking1;
    public Booking booking2;

    @Before
    public void setup(){
        hotel = new Hotel("CodeClan Towers");
        guest1 = new Guest("Eloise", "eloisecoveny@gmail.com", false);
        guest2 = new Guest("Alice", "alice@gmail.com", false);
        bedroom1 = new Bedroom(1, 2, "double", 85);
        bedroom2 = new Bedroom(2, 1, "single", 50);
        conferenceRoom1 = new ConferenceRoom("Desert room", 150, 85);
        diningRoom1 = new DiningRoom("Bassey room", 50, 150);
        booking1 = new Booking(bedroom1, 3);
        booking2 = new Booking(bedroom2, 1);
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
        hotel.bookRoom(bedroom1, guest1, 3);
        assertEquals(1, bedroom1.countGuests());
        assertEquals(true, guest1.isCheckedIn());
    }

    @Test
    public void hotelCanCheckMultipleGuestsIntoBedroom(){
        hotel.bookRoom(bedroom1, guest1, 3);
        hotel.bookRoom(bedroom1, guest2, 1);
        assertEquals(2, bedroom1.countGuests());
        assertEquals(true, guest1.isCheckedIn());
        assertEquals(true, guest2.isCheckedIn());
    }

    @Test
    public void hotelCanCheckMultipleGuestsOutOfBedroom(){
        hotel.bookRoom(bedroom1, guest1, 3);
        hotel.bookRoom(bedroom1, guest2, 1);
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

    @Test
    public void canGetBookings(){
        hotel.bookRoom(bedroom1, guest1, 3);
        hotel.bookRoom(bedroom2, guest2, 1);
        assertEquals(booking1.getBedroom(), hotel.getBookings().get(0).getBedroom());
        assertEquals(2, hotel.countBookings());
    }

    @Test
    public void roomBookingReturnsBill(){
        int bookingTotal = hotel.bookRoom(bedroom1, guest1, 3);
        assertEquals(255, bookingTotal);
    }

    @Test
    public void shouldReturnVacantRooms(){
        hotel.addBedroom(bedroom1);
        hotel.addBedroom(bedroom2);
        hotel.bookRoom(bedroom1, guest1, 3);
        assertEquals(1, bedroom1.countGuests());
        assertEquals(1, hotel.vacantRooms().size());
    }

}
