package entity;

public class Retailer extends User{
    public Retailer() {
    }

    public Retailer(String username, String password, String email, String phone, String userType, int locationID) {
        super(username, password, email, phone, userType, locationID);
    }

    public Retailer(int userID, String username, String password, String email, String phone, String userType, int locationID) {
        super(userID, username, password, email, phone, userType, locationID);
    }


}
