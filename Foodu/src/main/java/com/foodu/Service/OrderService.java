package com.foodu.Service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.foodu.Exception.OrderException;
import com.foodu.Model.Customer;
import com.foodu.Model.OrderDetails;
import com.foodu.Model.OrderItems;
import com.foodu.Model.Restaurant;



@Service
public interface OrderService {

	public OrderDetails addOrder(OrderDetails order) throws OrderException;
	public OrderDetails updateOrder(OrderDetails order) throws OrderException;
	public OrderDetails removeOrder(Integer id) throws OrderException;
	
	public List<OrderDetails> viewAllOrder() throws OrderException;
	public List<OrderDetails> viewAllOrders(Restaurant res) throws OrderException;
	public List<OrderDetails> viewAllOrders(Customer customer) throws OrderException;
	
}
