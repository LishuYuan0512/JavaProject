package entity;

public class Charity extends User{
    public Charity() {
    }

    public Charity(String username, String password, String email, String phone, String userType, int locationID) {
        super(username, password, email, phone, userType, locationID);
    }

    public Charity(int userID, String username, String password, String email, String phone, String userType, int locationID) {
        super(userID, username, password, email, phone, userType, locationID);
    }
}
