package com.foodu.Service;

import java.util.List;

import com.foodu.DTO.CustomerAddressDto;
import com.foodu.DTO.CustomerDTO;
import com.foodu.DTO.CustomerResDTO;
import com.foodu.DTO.GetRestaurantDto;
import com.foodu.Exception.AddressException;
import com.foodu.Exception.CustomerException;
import com.foodu.Exception.RestaurantException;
import com.foodu.Model.Address;
import com.foodu.Model.Customer;
import com.foodu.Model.CustomerRestaurantDTO;

public interface CustomerServiceDAO {
	
	
	public Customer registerCustomer(CustomerAddressDto customer) throws CustomerException;
	
	public Customer updateCustomer(CustomerAddressDto customer, String key) throws CustomerException;
	
	public String deleteCustomer(Integer customerId, String key) throws CustomerException;
	
	public List<CustomerRestaurantDTO> viewAllCustomersInRestaurant(Integer restaurantId, String key)throws RestaurantException, CustomerException;
	
	public CustomerDTO addAddress(Integer customerId, Address add, String key) throws CustomerException, AddressException;
	
	public CustomerDTO viewCustomerById(Integer customerId) throws RestaurantException ;
	
//	 public Customer addCustomer (Customer customer) throws CustomerException;
//
//	 public Customer updateCustomer (Customer customer) throws CustomerException;
//
//	 public Customer removeCustomer (Integer customerId)throws CustomerException;
//
//	 public Customer viewCustomer (Integer customerId)throws CustomerException;
//
//	 public List<Customer> viewAllCustomers ()throws CustomerException;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
