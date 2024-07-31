package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Purchase {
    private int purchaseId;
    private LocalDateTime purchaseTime;
    private int userID;
    private int itemID;
    private int quantity;
    private double price;
    private int priceTypeID;

    public Purchase() {
    }

    public Purchase(int purchaseId, LocalDateTime purchaseTime, int userID, int itemID, int quantity, double price, int priceTypeID) {
        this.purchaseId = purchaseId;
        this.purchaseTime = purchaseTime;
        this.userID = userID;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
        this.priceTypeID = priceTypeID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }





    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
}
