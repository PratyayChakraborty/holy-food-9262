package com.foodu.Service;

import java.util.List;
import com.foodu.Model.Customer;
import com.foodu.Model.Restaurant;

public interface CustomerServiceDAO {
	
	public Customer addCustomer (Customer customer);
	
	public Customer updateCustomer (Customer customer);
	
	public Customer removeCustomer (Customer customer);
	
	public Customer viewCustomer (Customer customer);
	
	public List<Customer> viewAllCustomers (Restaurant rest);

}
