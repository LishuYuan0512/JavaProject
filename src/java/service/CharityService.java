package service;

import entity.Charity;
import entity.Retailer;

public interface CharityService {
    public Charity login(String email, String password);
}
