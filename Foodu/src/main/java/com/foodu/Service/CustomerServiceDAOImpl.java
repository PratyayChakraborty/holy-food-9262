package com.foodu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.foodu.Exception.CustomerException;
import com.foodu.Model.Customer;
import com.foodu.Repository.CustomerRepository;

@Service
public class CustomerServiceDAOImpl implements CustomerServiceDAO{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
	Customer customer1 =customerRepository.save(customer);
		if(customer1==null) {
			throw new CustomerException("Customer not added");
		}else
		return customer1;
	}

	@Override
	public Customer updateCustomer(@RequestBody Customer customer) throws CustomerException {
	Customer customer2= customerRepository.findById(customer.getCustomerId()).orElseThrow(()-> new CustomerException("Customer not find with this id"));
	if(customer2 !=null) {
		customerRepository.save(customer);
	}
	
	return customer;
	}

	@Override
	public Customer removeCustomer(Integer customerId) throws CustomerException {
		Customer customer3= customerRepository.findById(customerId).orElseThrow(()-> new CustomerException("Customer not find with this id"));
		if(customer3 !=null) {
		customerRepository.delete(customer3);
		}
		return customer3;
	}

	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {
		Customer customer4=	customerRepository.findById(customerId).orElseThrow(()-> new CustomerException("Customer not find with this id"));
		return customer4;
	}

	@Override
	public List<Customer> viewAllCustomers(Customer customer) throws CustomerException {
		List<Customer> customer5=customerRepository.findAll();
		if(customer5.size()==0) {
			throw new CustomerException("customer not find");
		}
		return customer5;
	}

	
}
