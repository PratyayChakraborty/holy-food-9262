package com.foodu.Service;

import java.util.List;

import com.foodu.Exception.CustomerException;
import com.foodu.Model.Customer;

public interface CustomerServiceDAO {
	
	public Customer addCustomer (Customer customer) throws CustomerException;
	
	public Customer updateCustomer (Customer customer) throws CustomerException;
	
	public Customer removeCustomer (Integer customerId)throws CustomerException;
	
	public Customer viewCustomer (Integer customerId)throws CustomerException;
	
	public List<Customer> viewAllCustomers (Customer customer)throws CustomerException;

}
