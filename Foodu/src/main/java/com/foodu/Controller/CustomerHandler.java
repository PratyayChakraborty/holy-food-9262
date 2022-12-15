package com.foodu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodu.Exception.CustomerException;
import com.foodu.Model.Customer;
import com.foodu.Service.CustomerServiceDAO;

@RestController
public class CustomerHandler {
	
	@Autowired
	CustomerServiceDAO customerServiceDAO;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customer) throws CustomerException{
		Customer customer1=	customerServiceDAO.addCustomer(customer);

		return new ResponseEntity<Customer>(customer1,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updatedcustomer")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer customer) throws CustomerException{
		Customer customer2=	customerServiceDAO.updateCustomer(customer);
		
		return new ResponseEntity<Customer>(customer2,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/removecustomer/{customerId}")
	public ResponseEntity<Customer> removeCustomerHandler(@PathVariable ("customerId") Integer customerId){
		Customer customer3=	customerServiceDAO.removeCustomer(customerId);
		
		return new ResponseEntity<Customer>(customer3,HttpStatus.OK);
		
	}
	
	@GetMapping("/viewcustomerbyid/{customerId}")
	public ResponseEntity<Customer> viewCustomerByIdHandler(@PathVariable ("customerId") Integer customerId) throws CustomerException{
		Customer customer4=	customerServiceDAO.viewCustomer(customerId);
		
		return new ResponseEntity<Customer>(customer4,HttpStatus.OK);
	}
	
	@GetMapping("/viewallcustomers")
	public ResponseEntity<List<Customer>> viewAllCustomers(Customer customer) throws CustomerException {
		List<Customer> customer5=	customerServiceDAO.viewAllCustomers(customer);
		
		return new ResponseEntity<List<Customer>>(customer5,HttpStatus.OK);
	}
}
