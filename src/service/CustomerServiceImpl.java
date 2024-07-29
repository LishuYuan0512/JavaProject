package service;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import entity.Customer;
import utils.DbUtil;

public class CustomerServiceImpl implements CustomerService{
    private CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public Customer login(String email, String password) {
        Customer customer = null;
        try {
            DbUtil.begin();
            Customer temp = customerDAO.selectCustomerByEmail(email);
           if (temp!=null){
               if (temp.getPassword().equals(password)) {
                   customer = temp;
               }
           }
            DbUtil.commit();
        } catch (Exception e) {
            DbUtil.rollback();
            throw new RuntimeException(e);
        }
        return customer;
    }
}
