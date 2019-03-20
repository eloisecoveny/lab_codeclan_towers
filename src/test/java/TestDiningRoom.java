import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestDiningRoom {

    public DiningRoom diningRoom;
    public Guest guest1;
    public Guest guest2;

    @Before
    public void setup(){
        diningRoom = new DiningRoom("Bassey Room", 50, 150);
        guest1 = new Guest("Eloise", "eloisecoveny@gmail.com", false);
        guest2 = new Guest("Alice", "alice@gmail.com", false);
    }

    @Test
    public void roomHasAName(){
        assertEquals("Bassey Room", diningRoom.getName());
    }

    @Test
    public void roomHasACapacity(){
        assertEquals(50, diningRoom.getCapacity());
    }

    @Test
    public void roomHasAPrice(){
        assertEquals(150, diningRoom.getRate());
    }

    @Test
    public void roomStartsWithNoGuests(){
        assertEquals(0, diningRoom.countGuests());
    }

    @Test
    public void roomCanTakeInAGuest(){
        diningRoom.add(guest1);
        assertEquals(1, diningRoom.countGuests());
        assertEquals(true, guest1.isCheckedIn());
    }

    @Test
    public void roomCanTakeInMultipleGuests(){
        diningRoom.add(guest1);
        diningRoom.add(guest2);
        assertEquals(2, diningRoom.countGuests());
        assertEquals(true, guest1.isCheckedIn());
        assertEquals(true, guest2.isCheckedIn());
    }

    @Test
    public void roomCanGetAllGuests(){
        diningRoom.add(guest1);
        diningRoom.add(guest2);
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(guest1);
        guests.add(guest2);
        assertEquals(guests, diningRoom.getGuests());
        assertEquals(2, diningRoom.countGuests());
    }

    @Test
    public void roomCanRemoveGuest(){
        diningRoom.add(guest1);
        diningRoom.remove(guest1);
        assertEquals(0, diningRoom.countGuests());
        assertEquals(false, guest1.isCheckedIn());
    }
}
