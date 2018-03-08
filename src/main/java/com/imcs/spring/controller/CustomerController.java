package com.imcs.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imcs.spring.model.Customer;
import com.imcs.spring.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping("/add")
	public String addCustomer() {
		customerService.addCustomer();
		return "Customer added";
	}

	@RequestMapping("{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") Long id) {
		return customerService.getCustomer(id);
	}

	@RequestMapping("/all")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomers();
	}

	@RequestMapping("/delete/{id}")
	public String deleteCutomer(@PathVariable("id") Long id) {
		customerService.deleteCustomer(id);
		return "customer deleted of id = " + id;
	}
}
