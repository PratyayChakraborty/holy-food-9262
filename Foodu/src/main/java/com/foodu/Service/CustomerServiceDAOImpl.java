package com.foodu.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.foodu.DTO.CustomerAddressDto;
import com.foodu.DTO.CustomerDTO;
import com.foodu.DTO.CustomerResDTO;
import com.foodu.Exception.AddressException;
import com.foodu.Exception.CustomerException;
import com.foodu.Exception.RestaurantException;
import com.foodu.Model.Address;
import com.foodu.Model.CurrentUserSession;
import com.foodu.Model.Customer;
import com.foodu.Model.FoodCart;
import com.foodu.Repository.AddressRepo;
import com.foodu.Repository.CurrentUserRepo;
import com.foodu.Repository.CustomerRepository;
import com.foodu.Repository.RestaurantRepository;

@Service
public class CustomerServiceDAOImpl implements CustomerServiceDAO{
	
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private AddressRepo AddressRepo;
	@Autowired
	private RestaurantRepository restaurantRepo;
	@Autowired
	private CurrentUserRepo currUserRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CustomerRepository customerRepository;


	@Override
	public Customer registerCustomer(CustomerAddressDto customer) throws CustomerException {
		Customer customer1 = customerRepo.findByMobileNumber(customer.getMobileNumber());
		
		if(customer1 == null) {
			
			customer1 = customerRepo.findByEmail(customer.getEmail());
			
			if(customer1 == null) {
				
				Customer cust  = this.modelMapper.map(customer, Customer.class);
				
				FoodCart foodcart=new FoodCart();
				
				
				return customerRepo.save(cust);
				
			}else {
				
				throw new RestaurantException("Email already exists..");
				
			}
			
		}else {
			
			throw new RestaurantException("Mobile already exists..");
			
		}
			
		
	}


	@Override
	public Customer updateCustomer(CustomerAddressDto customer, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String deleteCustomer(Integer customerId, String key) throws CustomerException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<CustomerResDTO> viewAllCustomersInRestaurant(Integer restId, String key)
			throws RestaurantException, CustomerException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public CustomerDTO addAddress(Integer customerId, Address add, String key)
			throws CustomerException, AddressException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public CustomerDTO editAddress(Integer customerId, Address add, String key)
			throws CustomerException, AddressException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public CustomerDTO removeAddress(Integer customerId, Integer addId, String key)
			throws CustomerException, AddressException {
		// TODO Auto-generated method stub
		return null;
	}

		

	

	
}
























//@Override
//public Customer addCustomer(Customer customer) throws CustomerException {
//Customer customer1 =customerRepository.save(customer);
//	if(customer1==null) {
//		throw new CustomerException("Customer not added");
//	}else
//	return customer1;
//}
//
//@Override
//public Customer updateCustomer(@RequestBody Customer customer) throws CustomerException {
//Customer customer2= customerRepository.findById(customer.getCustomerId()).orElseThrow(()-> new CustomerException("Customer not find with this id"));
//if(customer2 !=null) {
//	customerRepository.save(customer);
//}
//
//return customer;
//}
//
//@Override
//public Customer removeCustomer(Integer customerId) throws CustomerException {
//	Customer customer3= customerRepository.findById(customerId).orElseThrow(()-> new CustomerException("Customer not find with this id"));
//	if(customer3 !=null) {
//	customerRepository.delete(customer3);
//	}
//	return customer3;
//}
//
//@Override
//public Customer viewCustomer(Integer customerId) throws CustomerException {
//	Customer customer4=	customerRepository.findById(customerId).orElseThrow(()-> new CustomerException("Customer not find with this id"));
//	return customer4;
//}
//
//@Override
//public List<Customer> viewAllCustomers() throws CustomerException {
//	List<Customer> customer5=customerRepository.findAll();
//	if(customer5.size()==0) {
//		throw new CustomerException("customer not find");
//	}
//	return customer5;
//}

