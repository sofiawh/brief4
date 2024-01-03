package com.joseph.service.Impl;

import java.util.List;

import com.joseph.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joseph.repository.CustomerRepository;
import com.joseph.entity.Customer;
// import com.joseph.exception.ResourceNotFoundException;
@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
    @Override
    @Transactional
    public List<Customer> getCustomersWithCommandes() {
        List<Customer> customers = customerRepository.findAll();
        customers.forEach(customer -> {
            customer.getCommandes().size(); // Load the commandes collection
        });
        return customers;
    }


    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) throws NullPointerException {
        return customerRepository.findById(id).orElseThrow(
                () -> new NullPointerException("Customer with ID = ${id} is not found"));
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerRepository.deleteById(theId);
    }

	@Override
	public List<Customer> searchCustomers(String keyword) {
		keyword = "%" + keyword + "%";	
		    return customerRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword, keyword);
	}
}
