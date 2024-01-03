package com.joseph.service;

import java.util.List;

import com.joseph.entity.Customer;
// import com.joseph..exception.ResourceNotFoundException;

public interface CustomerService {

    public List<Customer> getCustomers();
    
    public List<Customer> getCustomersWithCommandes();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);
    
    public List<Customer> searchCustomers(String keyword);

}