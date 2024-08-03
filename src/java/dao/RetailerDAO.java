package dao;

import entity.FoodItem;
import entity.Retailer;

import java.util.List;

public interface RetailerDAO {
    public List<Retailer> selectAllRetailers();
    public int deleteRetailer(int retailerID);
    public int insertRetailer(Retailer retailer);
    public int getRetailerIDByEmail(String email);
    public Retailer selectRetailerByEmail(String email);
    public String getUserTypeByUserID(Retailer retailer);
    
    // Add a method to get food items for a retailer
    List<FoodItem> getRetailerItems(int retailerID);
   
}
