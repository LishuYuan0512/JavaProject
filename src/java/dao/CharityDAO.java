package dao;

import entity.Charity;
import entity.Retailer;

public interface CharityDAO {
    public int insertCharity(Charity charity);
    public Charity selectCharityByEmail(String email);
}
