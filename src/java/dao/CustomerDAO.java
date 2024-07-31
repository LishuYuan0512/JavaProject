package dao;

import entity.Customer;

import java.util.List;

public interface CustomerDAO {
        public List<Customer> selectAllCustomer();
        public int deleteCustomer(String email);
        public int updateCustomer(Customer customer);
        public int insertCustomer(Customer customer);
        public Customer selectCustomerByEmail(String email);
        public int getUserIDByEmail(String email);
        public String getUserTypeByUserID(Customer customer);
}
