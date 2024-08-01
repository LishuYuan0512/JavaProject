package service;

import dao.CharityDAO;
import dao.CharityDAOImpl;
import entity.Charity;
import entity.Retailer;
import utils.DbUtil;

public class CharityServiceImpl implements CharityService{
    CharityDAO charityDAO = new CharityDAOImpl();
    @Override
    public Charity login(String email, String password) {
        Charity charity = null;
        try {
            DbUtil.begin();
            Charity temp = charityDAO.selectCharityByEmail(email);
            if (temp!=null){
                if (temp.getPassword().equals(password)) {
                    charity = temp;
                }
            }
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
        return charity;
    }

}
