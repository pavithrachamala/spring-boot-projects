package com.bankapp.model.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	public CustomerService service;

	@Override
	public Customer findByName(String name) {
		
		return service.findByName(name);
	}

	@Override
	public Customer findByEmail(String email) {
		
		return service.findByEmail(email);
	}

	@Override
	public Account findByAccountAccountNumber(Long accountNumber) {
		
		return service.findByAccountAccountNumber(accountNumber);
	}

}
