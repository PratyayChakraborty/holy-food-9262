package com.foodu.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.foodu.DTO.CustomerAddressDto;
import com.foodu.DTO.CustomerDTO;
import com.foodu.DTO.CustomerResDTO;
import com.foodu.DTO.GetRestaurantDto;
import com.foodu.Exception.AddressException;
import com.foodu.Exception.CustomerException;
import com.foodu.Exception.RestaurantException;
import com.foodu.Model.Address;
import com.foodu.Model.CurrentUserSession;
import com.foodu.Model.Customer;
import com.foodu.Model.CustomerRestaurantDTO;
import com.foodu.Model.FoodCart;
import com.foodu.Model.OrderDetails;
import com.foodu.Model.Restaurant;
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
	


	@Override
	public Customer registerCustomer(CustomerAddressDto customer) throws CustomerException {
		Customer customer1 = customerRepo.findByMobileNumber(customer.getMobileNumber());
		
		if(customer1 == null) {
			
			customer1 = customerRepo.findByEmail(customer.getEmail());
			
			if(customer1 == null) {
				
				customer1  = this.modelMapper.map(customer, Customer.class);
				
				FoodCart foodcart=new FoodCart();
				
				foodcart.setCustomer(customer1);
				customer1.setFoodCart(foodcart);
				
				return customerRepo.save(customer1);
				
			}else {
				
				throw new RestaurantException("Email already exists..");	
			}
		}else {
			
			throw new RestaurantException("Mobile already exists..");
		}
	}


	@Override
	public Customer updateCustomer(CustomerAddressDto customer, String key) throws CustomerException {
		CurrentUserSession curr = currUserRepo.findByUuid(key);
		
		if(curr == null) throw new CustomerException("No Customer Logged in with this key..");
		
		if(customer.getCustomerId()==curr.getUserId()) {
			
			Customer c = customerRepo.findById(customer.getCustomerId())
					.orElseThrow(() -> new CustomerException("You are not authorized.."));
		
			c = this.modelMapper.map(customer, Customer.class);
			
			return customerRepo.save(c);
		
		
		}else {
			throw new CustomerException("Enter Authorised Customer Id..");
		}
		
	}


	@Override
	public String deleteCustomer(Integer customerId, String key) throws CustomerException {
		CurrentUserSession curr = currUserRepo.findByUuid(key);
		
		if(curr == null) throw new CustomerException("No Customer Logged in with this key..");
		
		if(customerId == curr.getUserId()) {
			Customer cust = customerRepo.findById(customerId).orElseThrow(() -> new CustomerException("No such customer exists..."));
			
	  customerRepo.delete(cust);
		
	  return "Customer Successfully Deleted...";

		
		}else {
			
			throw new CustomerException("You are not authorized..");
			
		}
	}


	@Override
	public List<CustomerRestaurantDTO> viewAllCustomersInRestaurant(Integer restaurantId, String key)
			throws RestaurantException, CustomerException {
		
		CurrentUserSession curr = currUserRepo.findByUuid(key);
		
		if(curr == null) throw new RestaurantException("No Customer Logged in with this key..");
		
		if (curr.getUserId() == restaurantId) {

			Restaurant restaurant = restaurantRepo.findById(restaurantId).orElseThrow(() -> new RestaurantException(""));
		
			Set<Customer> cust= restaurant.getCustomers();
			
			List<CustomerRestaurantDTO> custResDetail=new ArrayList<>();
			
			for(Customer custom :cust) {
				CustomerRestaurantDTO crdto=new CustomerRestaurantDTO(custom.getFullName(),custom.getAge(),custom.getGender());
			List<OrderDetails> odList= custom.getOrders();
			List<OrderDetails> restaurentOrder=new ArrayList<>();
			for(OrderDetails od :odList) {
				if(od.getRestaurant().getRestaurantId()==restaurantId) {
					restaurentOrder.add(od);
				}
			}
			crdto.setOrders(restaurentOrder);
			
			custResDetail.add(crdto);
			
			
			}

		return custResDetail;
	}else {

		throw new CustomerException("You are not authorized Login With same Restaurant ID..");
	}
	}
		


	@Override
	public CustomerDTO addAddress(Integer customerId, Address add, String key)
			throws CustomerException, AddressException {
		CurrentUserSession curr = currUserRepo.findByUuid(key);
		
		if(curr == null) throw new CustomerException("No Customer Logged in with this key..");
		
		if(curr.getUserId()==customerId) {
			
			Customer cust = customerRepo.findById(customerId)
					.orElseThrow(()-> new CustomerException(""));
					
		
		Set<Address>address=cust.getAddresses();
		
		
	Address adr=AddressRepo.findByStreetPincodeBuilding(add.getBuilding(),add.getStreet(),add.getPincode());
		if(adr !=null) {
			throw new CustomerException("Address already added..");
		}
		address.add(adr);
		cust.setAddresses(address);
		cust=customerRepo.save(cust);
		return this.modelMapper.map(cust, CustomerDTO.class);
		} else {
			throw new CustomerException("You are not authorized..");
		}
	}



	@Override
	public CustomerDTO viewCustomerById(Integer customerId) throws RestaurantException {
		 Customer  cust=customerRepo.findById(customerId).orElseThrow(()->new RestaurantException("not find with this id"));
		
		 return this.modelMapper.map(cust, CustomerDTO.class);
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

