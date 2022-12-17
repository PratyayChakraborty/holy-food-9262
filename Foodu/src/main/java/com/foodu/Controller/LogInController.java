package com.foodu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodu.DTO.LogInDto;
import com.foodu.Exception.LoginException;
import com.foodu.Service.LoginService;


@RestController
public class LogInController {

	@Autowired
	private LoginService customerLogin;
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCustomerOrRestaurant(@RequestBody LogInDto dto) throws LoginException {
		
		String result = customerLogin.logIntoAccount(dto);	

		return new ResponseEntity<String>(result,HttpStatus.OK );
		
	}
	
	@PostMapping("/logout")
	public String logoutCustomerOrRestaurant(@RequestParam(required = false) String key) throws LoginException {
		return customerLogin.logOutFromAccount(key);
		
	}
	
	
	
}
