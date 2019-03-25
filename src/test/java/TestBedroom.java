import customer.Guest;
import org.junit.Before;
import org.junit.Test;
import rooms.Bedroom;
import rooms.BedroomType;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestBedroom {

    public Bedroom bedroom;
    public Guest guest1;
    public Guest guest2;

    @Before
    public void setup(){
        bedroom = new Bedroom("1", 2, BedroomType.DOUBLE, 85.00);
        guest1 = new Guest("Eloise", "eloisecoveny@gmail.com", false);
        guest2 = new Guest("Alice", "alice@gmail.com", false);
    }

    @Test
    public void getBedroomNumber(){
        assertEquals("1", bedroom.getIdentifier());
    }

    @Test
    public void getCapacity(){
        assertEquals(2, bedroom.getCapacity());
    }

    @Test
    public void getType(){
        assertEquals(BedroomType.DOUBLE, bedroom.getType());
    }

    @Test
    public void getPrice(){
        assertEquals(85.00, bedroom.getPrice(), 0);
    }

    @Test
    public void bedroomStartsWithNoGuests(){
        assertEquals(0, bedroom.countGuests());
    }

    @Test
    public void bedroomCanTakeInAGuest(){
        bedroom.add(guest1);
        assertEquals(1, bedroom.countGuests());
        assertEquals(true, guest1.isCheckedIn());
    }

    @Test
    public void bedroomCanTakeInMultipleGuests(){
        bedroom.add(guest1);
        bedroom.add(guest2);
        assertEquals(2, bedroom.countGuests());
        assertEquals(true, guest1.isCheckedIn());
        assertEquals(true, guest2.isCheckedIn());
    }

    @Test
    public void bedroomCanGetGuests(){
        bedroom.add(guest1);
        bedroom.add(guest2);
        ArrayList<Guest> guests = new ArrayList<Guest>();
        guests.add(guest1);
        guests.add(guest2);
        assertEquals(guests, bedroom.getGuests());
        assertEquals(2, bedroom.countGuests());
    }

    @Test
    public void bedroomCanRemoveGuest(){
        bedroom.add(guest1);
        bedroom.remove(guest1);
        assertEquals(0, bedroom.countGuests());
    }
}
