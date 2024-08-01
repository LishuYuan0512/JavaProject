package service;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.RetailerDAO;
import dao.RetailerDAOImpl;
import entity.Customer;
import entity.Retailer;
import utils.DbUtil;

public class RetailerServiceImpl implements RetailerService{
    private RetailerDAO retailerDAO = new RetailerDAOImpl();
    @Override
    public Retailer login(String email, String password) {
        Retailer retailer = null;
            try {
                DbUtil.begin();
                Retailer temp = retailerDAO.selectRetailerByEmail(email);
                if (temp!=null){
                    if (temp.getPassword().equals(password)) {
                        retailer = temp;
                    }
                }
                DbUtil.commit();
            } catch (Exception e) {
                DbUtil.rollback();
                throw new RuntimeException(e);
            }
            return retailer;
    }
}
