package com.bankapp.model.service;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;

public interface CustomerService {
	 Customer findByName(String name);
    Customer findByEmail(String email);
    Account findByAccountAccountNumber(Long accountNumber);

}
