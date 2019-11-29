package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountTransaction;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionService;
import com.bankapp.web.bean.config.AccountRequest;
import com.bankapp.web.bean.config.AccountUpdate;

@RestController
@RequestMapping(path="/api")
public class AccountRestController {
	
	@Autowired
	private AccountService service;
	
	@Autowired
	private TransactionService transactionService;
	
	
	@PostMapping(path="/account",produces=MediaType.APPLICATION_JSON_VALUE,
								consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addAccount(@RequestBody AccountRequest accountreq)
	{
		Account account=new Account(accountreq.getBalance(), false);
		Customer customer=new Customer(accountreq.getName(), accountreq.getEmail(), accountreq.getPhone(), 
				accountreq.getAddress(), accountreq.getCity(), accountreq.getCountry());
		
		account.setCustomer(customer);
		service.createAccount(account);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	@PutMapping(path="/account/{accountNumber}",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateAccount(@PathVariable (name="accountNumber")Long accountNumber,
			@RequestBody AccountUpdate accountUpdate){
			
//					System.out.println(accountUpdate);
					Account account=service.findByAccountNumber(accountNumber);
					account.getCustomer().setEmail(accountUpdate.getEmail());
					account.getCustomer().setPhone(accountUpdate.getPhone());
					account.getCustomer().setAddress(accountUpdate.getAddress());
					account.getCustomer().setCity(accountUpdate.getCity());
					account.getCustomer().setCountry(accountUpdate.getCountry());
					
					service.updateAccount(account,accountNumber);
					return new ResponseEntity<Void>(HttpStatus.OK);
	}		
	
	
	@GetMapping(path="/account/{accountNumber}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> getAccount(@PathVariable(name="accountNumber")Long accountNumber)
	{
		return new ResponseEntity<Account>(service.findByAccountNumber(accountNumber),HttpStatus.OK);
	}
	
	
	@GetMapping(path="/account",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> getAllAccounts()
	{
		return new ResponseEntity<List<Account>>(service.findAll(),HttpStatus.OK);
	}
	
	
	
	@GetMapping(path="/account/delete/{accountNumber}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> delete(@PathVariable(name="accountNumber")Long accountNumber)
	{
		service.deleteAccount(accountNumber);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@GetMapping(path="/account/transactionlist",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountTransaction>> getAllTransactions()
	{
		
		return new ResponseEntity<List<AccountTransaction>>(transactionService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path="/account/transactionlist/{accountNumber}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountTransaction>> transactionlistByaccountnumber(@PathVariable(name="accountNumber")Long accountNumber)
	{
		transactionService.findByAccountAccountNumber(accountNumber);
		return new ResponseEntity<List<AccountTransaction>>(HttpStatus.OK);
	}
	
}
