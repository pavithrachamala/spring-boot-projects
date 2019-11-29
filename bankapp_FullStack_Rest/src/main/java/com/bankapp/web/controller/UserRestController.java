package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.entities.User;
import com.bankapp.model.repo.TransactionLogRepository;
import com.bankapp.model.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {
	
	/*@GetMapping(path="mylogin")
	public String login()
	{
		return "loginpage";
	}*/

	
	@GetMapping(path="/admin")
	public String admin()
	{
		return "hello to admin";
	}

	@GetMapping(path="/mgr")
	public String mgr()
	{
		return "hello to mgr";
	}

	@GetMapping(path="/clerk")
	public String clerk()
	{
		return "hello to clerk";
	}
	@GetMapping(path="/home")
	public String home()
	{
		return "home";
	}

	@Autowired
	private UserService service;
	
	@Autowired
	private TransactionLogRepository transactionLogRepository;
	
	@GetMapping(path="/user",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers()
	{
		return new ResponseEntity<List<User>>(service.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path="/user/{email}",produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<User> getAnAccount(@PathVariable(name="email")String email)
		{
			User user=service.findByEmail(email);
			return new ResponseEntity<User>(user,HttpStatus.OK);
			
		}
	@PostMapping(path="/user",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		service.addUser(user);
		return new ResponseEntity<User>(HttpStatus.OK);
			
	}
	
	@DeleteMapping(path="/user/{userId}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> delete(@PathVariable (name="userId")Long userId)
	{
		service.deleteUser(userId);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	@GetMapping(path="/user/alltransactions",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionLog>> getAllTransactions()
	{
		return new ResponseEntity<List<TransactionLog>>(transactionLogRepository.findAll(),HttpStatus.OK);
	}

}
