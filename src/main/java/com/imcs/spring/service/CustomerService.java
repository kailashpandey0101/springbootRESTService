package com.imcs.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imcs.spring.dao.CustomerDao;
import com.imcs.spring.model.Customer;

@Service
public class CustomerService implements ICustomerService{

	@Autowired
	private CustomerDao customerDao;

	public Optional<Customer> getCustomer(Long id) {
		return customerDao.findById(id);
	}

	public void addCustomer() {
		Customer customer = new Customer("Kailash", "Pandey", "654-555-5555");
		customerDao.save(customer);
	}

	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerDao.findAll();
	}
	
	public void deleteCustomer(Long id) {
		customerDao.deleteById(id);
	}
}
