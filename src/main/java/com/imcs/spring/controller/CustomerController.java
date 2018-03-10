package com.imcs.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imcs.spring.model.Customer;
import com.imcs.spring.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addPerson(@RequestBody Customer customer) {
		boolean flag = customerService.addCustomer(customer);
		if (flag)
			return new ResponseEntity(HttpStatus.CREATED);
		else
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET, consumes = { "application/json" }, produces = {
			"application/json" })
	public Optional<Customer> getCustomerById(@PathVariable("id") Long id) {
		return customerService.getCustomer(id);
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public ResponseEntity<?> getAllCustomer() {
		return new ResponseEntity(customerService.getAllCustomers(), HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity(HttpStatus.ACCEPTED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);

		return new ResponseEntity(HttpStatus.ACCEPTED);

	}
}
