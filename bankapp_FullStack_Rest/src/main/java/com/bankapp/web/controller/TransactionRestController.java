package com.bankapp.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.service.AccountService;
import com.bankapp.web.bean.config.DepositeOrWithdrawRequest;
import com.bankapp.web.bean.config.TransferRequest;
@RestController
@RequestMapping(path="/api")
public class TransactionRestController {
	
	@Autowired
	private AccountService service;
	
	@PostMapping(path="/transaction/deposit",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deposite(@RequestBody DepositeOrWithdrawRequest dipositeorwithdrawrequest,Principal principal)
	{
		service.deposit(dipositeorwithdrawrequest.getAccountNumber(), dipositeorwithdrawrequest.getAmount(),principal.getName());
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
		
	@PostMapping(path="/transaction/withdraw",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> withdraw(@RequestBody DepositeOrWithdrawRequest dipositeorwithdrawrequest,Principal principal)
	{
		service.withdraw(dipositeorwithdrawrequest.getAccountNumber(),dipositeorwithdrawrequest.getAmount(),principal.getName());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PostMapping(path="/transaction/transfer",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> transfer(@RequestBody TransferRequest transferRequest,Principal principal)
	{
		service.transfer(transferRequest.getFromAccount(),transferRequest.getToAccount(),transferRequest.getAmount(),principal.getName());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
