package customer;

public class Guest {

    private String name;
    private String email;
    private Boolean checkedIn;

    public Guest(String name, String email, Boolean checkedIn){
        this.name = name;
        this.email = email;
        this.checkedIn = checkedIn;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public Boolean isCheckedIn(){
        return this.checkedIn;
    }

    public void checkIn(){
        this.checkedIn = true;
    }

    public void checkOut(){
        this.checkedIn = false;
    }
}
