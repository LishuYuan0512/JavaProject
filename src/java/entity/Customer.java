package entity;

public class Customer extends User{
    public Customer() {
    }

    public Customer(String username, String password, String email, String phone, String userType, int locationID) {
        super(username, password, email, phone, userType, locationID);
    }

    @Override
    public String toString() {
        return this.getUsername() + " " + this.getPassword() + " " + this.getEmail() + " " + this.getPhone() + " " + this.getUserType();
    }
}
