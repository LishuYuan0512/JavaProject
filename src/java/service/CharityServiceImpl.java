package service;

import dao.CharityDAO;
import dao.CharityDAOImpl;
import entity.Charity;
import entity.Retailer;
import utils.DbUtil;

/**
 * Implementation of the CharityService interface, providing methods for charity operations.
 * This class handles charity authentication with transaction management.
 */

public class CharityServiceImpl implements CharityService{
    CharityDAO charityDAO = new CharityDAOImpl();
    
    /**
     * Authenticates a charity using the provided email and password.
     * Begins a transaction, retrieves the charity from the database by email,
     * and checks if the password matches.
     *
     * @param email    The email address of the charity trying to log in.
     * @param password The password associated with the charity's account.
     * @return The Charity object if authentication is successful; otherwise, returns null.
     * @throws RuntimeException if an error occurs during the authentication process.
     */
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
