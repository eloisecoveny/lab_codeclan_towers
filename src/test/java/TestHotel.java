import customer.Guest;
import hotelManagement.Booking;
import hotelManagement.Hotel;
import org.junit.Before;
import org.junit.Test;
import rooms.Bedroom;
import rooms.BedroomType;
import rooms.ConferenceRoom;
import rooms.DiningRoom;

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

        bedroom1 = new Bedroom("1", 2, BedroomType.DOUBLE, 85);
        bedroom2 = new Bedroom("2", 1, BedroomType.SINGLE, 50);

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
        bedroom1.occupy();
        assertEquals(1, bedroom1.countGuests());
        assertEquals(true, guest1.isCheckedIn());
        assertEquals(true, bedroom1.isOccupied());
    }

    @Test
    public void hotelCanCheckMultipleGuestsIntoBedroom(){
        hotel.bookRoom(bedroom1, guest1, 3);
        hotel.bookRoom(bedroom1, guest2, 1);
        bedroom1.occupy();
        assertEquals(2, bedroom1.countGuests());
        assertEquals(true, guest1.isCheckedIn());
        assertEquals(true, guest2.isCheckedIn());
    }

    @Test
    public void hotelCanCheckMultipleGuestsOutOfBedroom(){
        hotel.bookRoom(bedroom1, guest1, 3);
        hotel.bookRoom(bedroom1, guest2, 1);
        bedroom1.occupy();
        hotel.checkGuestsOutOfBedroom(bedroom1);
        assertEquals(0, bedroom1.countGuests());
        assertEquals(false, bedroom1.isOccupied());
        assertEquals(false, guest1.isCheckedIn());
        assertEquals(false, guest2.isCheckedIn());
    }

    @Test
    public void hotelCanCheckGuestIntoConferenceRoom(){
        hotel.makeConferenceRoomBooking(conferenceRoom1, guest1);
        conferenceRoom1.occupy();
        assertEquals(1, conferenceRoom1.countGuests());
        assertEquals(true, guest1.isCheckedIn());
        assertEquals(true, conferenceRoom1.isOccupied());
    }

    @Test
    public void hotelCanCheckMultipleGuestsOutOfConferenceRoom(){
        hotel.makeConferenceRoomBooking(conferenceRoom1, guest1);
        hotel.makeConferenceRoomBooking(conferenceRoom1, guest2);
        conferenceRoom1.occupy();
        hotel.checkGuestsOutOfConferenceRoom(conferenceRoom1);
        assertEquals(0, conferenceRoom1.countGuests());
        assertEquals(false, guest1.isCheckedIn());
        assertEquals(false, guest2.isCheckedIn());
        assertEquals(false, conferenceRoom1.isOccupied());
    }

    @Test
    public void hotelCanCheckGuestIntoDiningRoom(){
        hotel.makeDiningRoomBooking(diningRoom1, guest1);
        diningRoom1.occupy();
        assertEquals(1, diningRoom1.countGuests());
        assertEquals(true, guest1.isCheckedIn());
        assertEquals(true, diningRoom1.isOccupied());
    }

    @Test
    public void hotelCanCheckMultipleGuestsOutOfDiningRoom(){
        hotel.makeDiningRoomBooking(diningRoom1, guest1);
        hotel.makeDiningRoomBooking(diningRoom1, guest2);
        diningRoom1.occupy();
        hotel.checkGuestsOutOfDiningRoom(diningRoom1);
        assertEquals(0, diningRoom1.countGuests());
        assertEquals(false, guest1.isCheckedIn());
        assertEquals(false, guest2.isCheckedIn());
        assertEquals(false, diningRoom1.isOccupied());
    }

    @Test
    public void canGetBookings(){
        hotel.bookRoom(bedroom1, guest1, 3);
        bedroom1.occupy();
        hotel.bookRoom(bedroom2, guest2, 1);
        bedroom2.occupy();
        assertEquals(booking1.getBedroom(), hotel.getBookings().get(0).getBedroom());
        assertEquals(2, hotel.countBookings());
    }

    @Test
    public void roomBookingReturnsBill(){
        hotel.bookRoom(bedroom1, guest1, 2);
        hotel.bookRoom(bedroom1, guest2, 3);
        assertEquals(255, bedroom1.getBill(), 0);
    }

    @Test
    public void shouldReturnVacantRooms(){
        hotel.addBedroom(bedroom1);
        hotel.addBedroom(bedroom2);
        hotel.bookRoom(bedroom1, guest1, 3);
        bedroom1.occupy();
        assertEquals(1, bedroom1.countGuests());
        assertEquals(1, hotel.vacantRooms().size());
    }

}
