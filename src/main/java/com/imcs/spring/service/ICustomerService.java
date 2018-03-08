package com.imcs.spring.service;

import java.util.List;
import java.util.Optional;

import com.imcs.spring.model.Customer;

public interface ICustomerService {

	public Optional<Customer> getCustomer(Long id);

	public void addCustomer();

	public List<Customer> getAllCustomers();

	public void deleteCustomer(Long id);
}
