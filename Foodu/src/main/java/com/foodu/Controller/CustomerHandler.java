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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodu.DTO.CustomerAddressDto;
import com.foodu.DTO.CustomerDTO;
import com.foodu.Exception.AddressException;
import com.foodu.Exception.CustomerException;
import com.foodu.Exception.RestaurantException;
import com.foodu.Model.Address;
import com.foodu.Model.Customer;
import com.foodu.Model.CustomerRestaurantDTO;

import com.foodu.Service.CustomerServiceDAO;

@RestController
public class CustomerHandler {
	
	@Autowired
	CustomerServiceDAO customerServiceDAO;
	
	@PostMapping("/registor")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody CustomerAddressDto customer) throws CustomerException{
		Customer customer1=	customerServiceDAO.registerCustomer(customer);

		return new ResponseEntity<Customer>(customer1,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updatedcustomer")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody CustomerAddressDto customer, String key) throws CustomerException{
		Customer customer2=	customerServiceDAO.updateCustomer(customer, key);
		
		return new ResponseEntity<Customer>(customer2,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> DeleteCustomerHandler(@RequestParam Integer customerId, @RequestParam String key)
			throws CustomerException {
		String cus = customerServiceDAO.deleteCustomer(customerId, key);

		return new ResponseEntity<String>(cus, HttpStatus.OK);
	}

	
	@GetMapping("/viewcustomerbyid/{customerId}")
	public ResponseEntity<CustomerDTO> viewCustomerByIdHandler(@PathVariable ("customerId") Integer customerId) throws CustomerException{
		CustomerDTO customer4=	customerServiceDAO.viewCustomerById(customerId);
		
		return new ResponseEntity<CustomerDTO>(customer4,HttpStatus.OK);
	}
	
	@GetMapping("/customer")
	public ResponseEntity<List<CustomerRestaurantDTO>>  viewAllCustomersInRestaurant(@RequestParam Integer restId,@RequestParam String key)throws RestaurantException, CustomerException{
		
		List<CustomerRestaurantDTO> list = customerServiceDAO.viewAllCustomersInRestaurant(restId, key);
		
		return new ResponseEntity<List<CustomerRestaurantDTO>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/address/add") // --tested--
	public ResponseEntity<CustomerDTO> addAddress(@RequestParam Integer customerId, @RequestBody Address add,
			@RequestParam String key) throws CustomerException, AddressException {
		CustomerDTO cdto = customerServiceDAO.addAddress(customerId, add, key);

		return new ResponseEntity<CustomerDTO>(cdto, HttpStatus.ACCEPTED);

	}
	
}
