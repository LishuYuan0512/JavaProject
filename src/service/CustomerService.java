package service;

import entity.Customer;

public interface CustomerService {
    public Customer login(String email, String password);
}
