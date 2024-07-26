package dao;

import entity.Customer;

import java.util.List;

public interface CustomerDAO {
        public List<Customer> selectAllCustomer();
        public int deleteCustomer(int id);
        public int updateCustomer(Customer customer);
        public int insertCustomer(Customer customer);
        public Customer selectCustomerById(int id);
}
