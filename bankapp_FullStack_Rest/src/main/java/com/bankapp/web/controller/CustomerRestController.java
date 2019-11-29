package com.bankapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Customer;
import com.bankapp.model.service.CustomerService;

@RestController
@RequestMapping(path="/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService service;
	
	@GetMapping(path="/customer/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getByName(@PathVariable(name="name")String name)
	{
		return new ResponseEntity<Customer>(service.findByName(name),HttpStatus.OK);
	}
}
