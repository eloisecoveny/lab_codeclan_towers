import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGuest {

    public Guest guest;

    @Before
    public void setup(){
        guest = new Guest("Eloise", "eloisecoveny@gmail.com", false);
    }

    @Test
    public void guestHasName(){
        assertEquals("Eloise", guest.getName());
    }

    @Test
    public void guestHasEmail(){
        assertEquals("eloisecoveny@gmail.com", guest.getEmail());
    }

    @Test
    public void checkIfGuestIsCheckedIn(){
        assertEquals(false, guest.isCheckedIn());
    }

    @Test
    public void guestCanBeCheckedIn(){
        guest.checkIn();
        assertEquals(true, guest.isCheckedIn());
    }

    @Test
    public void guestCanBeCheckedOut(){
        guest.checkOut();
        assertEquals(false, guest.isCheckedIn());
    }
}
