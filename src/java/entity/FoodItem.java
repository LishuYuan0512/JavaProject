package entity;


import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;


public class FoodItem {
    private int itemID;
    private int userID;
    private String itemName;
    private int quantity;
    private Date restockTime;
    private Date expirationDate;
    private double price;
    private int priceTypeID;
    private int isPlus;
    private double discount;
    public FoodItem() {
    }

    public FoodItem(int itemID, int userID, String itemName, int quantity, Date restockTime, Date expirationDate, double price, int priceTypeID, int isPlus) {
        this.itemID = itemID;
        this.userID = userID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.restockTime = restockTime;
        this.expirationDate = expirationDate;
        this.price = price;
        this.priceTypeID = priceTypeID;
        this.isPlus = isPlus;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getRestockTime() {
        return restockTime;
    }

    public void setRestockTime(Date restockTime) {
        this.restockTime = restockTime;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPriceTypeID() {
        return priceTypeID;
    }

    public void setPriceTypeID(int priceTypeID) {
        this.priceTypeID = priceTypeID;
    }

    public int getIsPlus() {
        return isPlus;
    }

    public void setIsPlus(int isPlus) {
        this.isPlus = isPlus;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "itemID=" + itemID +
                ", userID=" + userID +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", restockTime=" + restockTime +
                ", expirationDate=" + expirationDate +
                ", price=" + price +
                ", priceTypeID=" + priceTypeID +
                '}';
    }

    public boolean isDateWithin7Days(Date expirationDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expirationDate);
        long expirationTime = calendar.getTimeInMillis();

        calendar.setTime(new Date());
        long currentTime = calendar.getTimeInMillis();

        long diffInMillis = expirationTime - currentTime;
        long diffInDays = diffInMillis / (1000 * 60 * 60 * 24);

        return diffInDays < 7;
    }
}