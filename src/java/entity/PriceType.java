package entity;

public class PriceType {
    private int priceTypeID;
    private String priceType;

    public PriceType() {
    }

    public PriceType(int priceTypeID, String priceType) {
        this.priceTypeID = priceTypeID;
        this.priceType = priceType;
    }

    public int getPriceTypeID() {
        return priceTypeID;
    }

    public void setPriceTypeID(int priceTypeID) {
        this.priceTypeID = priceTypeID;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }
}
