package dao;

import entity.Customer;
import entity.Retailer;

import java.util.List;

public interface RetailerDAO {
    public List<Retailer> selectAllRetailers();
    public int deleteRetailer(int retailerID);
    public int insertRetailer(Retailer retailer);
    public int getRetailerIDByEmail(String email);
    public Retailer selectRetailerByEmail(String email);
    public String getUserTypeByUserID(Retailer retailer);
}
