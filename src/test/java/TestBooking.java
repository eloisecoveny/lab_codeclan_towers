import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBooking {

    public Booking booking1;
    public Booking booking2;
    public Bedroom bedroom1;
    public Bedroom bedroom2;
    public Guest guest1;
    public Guest guest2;
    public Guest guest3;

    @Before
    public void setup(){
        bedroom1 = new Bedroom(1, 2, "double", 85);
        bedroom2 = new Bedroom(2, 1, "single", 50);

        guest1 = new Guest("Eloise", "eloisecoveny@gmail.com", false);
        guest2 = new Guest("Martin Heidegger", "heidegger@gmail.com", false);
        guest3 = new Guest("Marlene Dietrich", "marlene@gmail.com", false);

        booking1 = new Booking(bedroom1, 3);
        booking2 = new Booking(bedroom2, 1);
    }

    @Test
    public void bookingHasBedroom(){
        assertEquals(bedroom1, booking1.getBedroom());
    }

    @Test
    public void bookingHasNumberOfNights(){
        assertEquals(3, booking1.getNights());
    }

    @Test
    public void bookingCanCalculateBill(){
        assertEquals(255, booking1.getBill());
        assertEquals(50, booking2.getBill());
    }
}
