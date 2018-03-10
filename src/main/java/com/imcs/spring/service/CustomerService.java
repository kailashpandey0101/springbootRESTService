package com.imcs.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imcs.spring.dao.CustomerDao;
import com.imcs.spring.model.Customer;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private CustomerDao customerDao;

	public Optional<Customer> getCustomer(Long id) {
		return customerDao.findById(id);
	}

	public boolean addCustomer(Customer customer) {
		return customerDao.save(customer) != null;
	}

	public List<Customer> getAllCustomers() {
		return (List<Customer>) customerDao.findAll();
	}

	public void deleteCustomer(Long id) {
		customerDao.deleteById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {

		Customer customerToUpdate = customerDao.findCustomerById(customer.getId());
		customerToUpdate.setFirstName(customer.getFirstName());
		customerToUpdate.setLastName(customer.getLastName());
		customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
		customerDao.save(customerToUpdate);

	}
}
