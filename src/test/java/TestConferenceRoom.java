import customer.Guest;
import org.junit.Before;
import org.junit.Test;
import rooms.ConferenceRoom;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestConferenceRoom {

    public ConferenceRoom conferenceRoom;
    public Guest guest1;
    public Guest guest2;

    @Before
    public void setup(){
        conferenceRoom = new ConferenceRoom("Desert room", 150, 50);
        guest1 = new Guest("Eloise", "eloisecoveny@gmail.com", false);
        guest2 = new Guest("Alice", "alice@gmail.com", false);
    }

    @Test
    public void roomHasAName(){
        assertEquals("Desert room", conferenceRoom.getIdentifier());
    }

    @Test
    public void roomHasCapacity(){
        assertEquals(150, conferenceRoom.getCapacity());
    }

    @Test
    public void roomHasHourlyRate(){
        assertEquals(50, conferenceRoom.getPrice(), 0);
    }

    @Test
    public void roomStartsWithNoGuests(){
        assertEquals(0, conferenceRoom.countGuests());
    }

    @Test
    public void roomCanTakeInAGuest(){
        conferenceRoom.add(guest1);
        assertEquals(1, conferenceRoom.countGuests());
        assertEquals(true, guest1.isCheckedIn());
    }

    @Test
    public void roomCanTakeInMultipleGuests(){
        conferenceRoom.add(guest1);
        conferenceRoom.add(guest2);
        assertEquals(2, conferenceRoom.countGuests());
        assertEquals(true, guest1.isCheckedIn());
        assertEquals(true, guest2.isCheckedIn());
    }

    @Test
    public void roomCanGetAllGuests(){
        conferenceRoom.add(guest1);
        conferenceRoom.add(guest2);
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(guest1);
        guests.add(guest2);
        assertEquals(guests, conferenceRoom.getGuests());
        assertEquals(2, conferenceRoom.countGuests());
    }

    @Test
    public void roomCanRemoveGuest(){
        conferenceRoom.add(guest1);
        conferenceRoom.remove(guest1);
        assertEquals(0, conferenceRoom.countGuests());


    }
}
