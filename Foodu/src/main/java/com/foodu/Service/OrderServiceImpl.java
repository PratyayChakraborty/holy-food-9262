package com.foodu.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodu.Exception.OrderException;
import com.foodu.Model.Address;
import com.foodu.Model.Bill;
import com.foodu.Model.Customer;
import com.foodu.Model.OrderDetails;
import com.foodu.Model.OrderItems;
import com.foodu.Model.Restaurant;
import com.foodu.Repository.AddressRepo;
import com.foodu.Repository.BillRepository;

import com.foodu.Repository.CustomerRepository;
import com.foodu.Repository.OrderRepo;
import com.foodu.Repository.RestaurantRepo;



@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepo orderRepo;
    
	@Autowired
	private AddressRepo addrRepo;
	
	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private BillRepository billRepo;
	
	@Autowired
	private RestaurantRepo rest;
	 
	@Override
	public OrderDetails addOrder(OrderDetails order) throws OrderException {
	     OrderDetails od = orderRepo.save(order);
	     if(od != null) {
	    	 return od;
	     }else {
	    	 throw new OrderException("Order Not Added...");
	     }
	}


	@Override
	public OrderDetails updateOrder(OrderDetails order) throws OrderException {
	    Optional<OrderDetails> od = orderRepo.findById(order.getOrderId());
	    if(od.isPresent()) {
	    	OrderDetails newOrderDetails = orderRepo.save(order);
	    	
	    	return newOrderDetails;
	    }else{
	    	throw new OrderException("Order Id Not Found..");
	    }
	}

	@Override
	public OrderDetails removeOrder(Integer id) throws OrderException {
		 Optional<OrderDetails> od = orderRepo.findById(id);
		    if(od.isPresent()) {
		    	
		    	OrderDetails newOrderDetails = od.get();
		        orderRepo.delete(newOrderDetails);
		    	return newOrderDetails;
		    }else{
		    	throw new OrderException("Order Id Not Found..");
		    }
	}

	

	@Override
	public List<OrderDetails> viewAllOrder() throws OrderException {
		
	
		List<OrderDetails> orderList = orderRepo.findAll();
		
		if(orderList.size() == 0) {
			throw new OrderException("No Order Found..");
		}else {
		  return orderList;
		}

	}

	@Override
	public List<OrderDetails> viewAllOrders(Restaurant res) throws OrderException {
	
//		List<OrderDetails> orderList = res.getOrderLists();
//		if(orderList.size() == 0) {
//			throw new OrderException("No Order Found..");
//		}else {
//		  return orderList;
//		}
		return null;
	}

	@Override
	public List<OrderDetails> viewAllOrders(Customer customer) throws OrderException {
	return null;	
//		List<OrderDetails> orderList = customer.getOrders();
//		
//		if(orderList.size() == 0) {
//			throw new OrderException("No Order Found..");
//		}else {
//		  return orderList;
//		}
	}

	

	@Override
	public List<Address> viewAllAdress() throws OrderException {
	
	
		
		List<Address> addList = addrRepo.findAll();
		
		if(addList.size()== 0) {
			throw new OrderException("Address Not Found");
		}else {
			return  addList;
		}
		
	}

	@Override
	public Customer GetCustomer(Integer id) throws OrderException {
		 Optional<Customer> customer =  customerRepo.findById(id);
		 if(customer.isPresent()) {
			 Customer cust  = customer.get();
			 return  cust;
		 }else {
			 throw new OrderException("Customer Not Found...");
		 }
	}

	@Override
	public Bill GetBill(Integer id) throws OrderException{
		Boolean flag = true;
		
		    Bill bill = null;
			List<Bill> billList = billRepo.findAll();
			for(Bill b:billList) {
				if((b.getOrder().getOrderId()) == id) {
					bill = b;
					flag = false;
					break;
				}
			}
			
			if(flag) {
				throw new OrderException("Bill Not Found...");
			}else {
				return bill;
			}
			
	  }
	

	@Override
	public Restaurant getRestaurant(Integer id) throws OrderException {
		Integer orderID;
		Restaurant restaurant =null;
		 Optional<Customer> customer =  customerRepo.findById(id);
		 if(customer.isPresent()) {
			 Customer  cust  =  customer.get();
			 List<OrderDetails> orderList = cust.getOrders();
			  orderID = orderList.get(orderList.size()-1).getOrderId();
		 }else {
			 throw new OrderException("NO order found...");
		 }
		
		 boolean flag = true;
		List<Restaurant> restList = rest.findAll();
		for(Restaurant res:restList) {
		 List<OrderDetails> restOrderList = res.getOrderLists();
			if((restOrderList.get(restOrderList.size()-1).getOrderId()) == orderID) {
				restaurant = res;
				flag =false;
				break;
			}
		}
		
		if(flag) {
			throw new OrderException("No Restaurant Found...");
		}else {
			return restaurant;
		}
	}


	@Override
	public List<OrderDetails> getOrderDetailsFromCustomerID(Integer id) throws OrderException {
		 Optional<Customer> customer =  customerRepo.findById(id);
		 if(customer.isPresent()) {
			 Customer  cust  =  customer.get();
			 List<OrderDetails> oList = cust.getOrders();
			 return oList;
		 }else {
			 throw new OrderException("NO order found...");
		 }
	}
}
