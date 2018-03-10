package com.imcs.spring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imcs.spring.model.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Long> {

	Customer findCustomerById(Long id);
}
