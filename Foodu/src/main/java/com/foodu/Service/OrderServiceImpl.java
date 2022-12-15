package com.foodu.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodu.Exception.OrderException;
import com.foodu.Model.Customer;
import com.foodu.Model.OrderDetails;
import com.foodu.Model.OrderItems;
import com.foodu.Model.Restaurant;
import com.foodu.Repository.OrderRepo;



@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepo orderRepo;

	@Override
	public OrderDetails addOrder(OrderDetails order) throws OrderException {
	     OrderDetails od = orderRepo.save(order);
	     if(od != null) {
	    	 return od;
	     }else {
	    	 throw new OrderException("Order Not Added..");
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
	
		List<OrderDetails> orderList = res.getOrderLists();
		if(orderList.size() == 0) {
			throw new OrderException("No Order Found..");
		}else {
		  return orderList;
		}
		
	}

	@Override
	public List<OrderDetails> viewAllOrders(Customer customer) throws OrderException {
		
		List<OrderDetails> orderList = customer.getOrders();
		
		if(orderList.size() == 0) {
			throw new OrderException("No Order Found..");
		}else {
		  return orderList;
		}
	}

	

}
