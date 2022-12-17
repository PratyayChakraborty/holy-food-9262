package com.foodu.Service;

import java.util.List;

import com.foodu.DTO.OrderDto;
import com.foodu.DTO.RestOrderDto;
import com.foodu.Exception.AddressException;
import com.foodu.Exception.CartException;
import com.foodu.Exception.CustomerException;
import com.foodu.Exception.ItemException;
import com.foodu.Exception.OrderDetailsException;
import com.foodu.Exception.RestaurantException;
import com.foodu.Model.OrderDetails;

public interface OrderDetailsService {
	
	
	public OrderDetails addDetails(Integer addressId, String key) throws OrderDetailsException, CustomerException, AddressException, CartException;
	
	public OrderDetails updateItem(Integer itemId, Integer orderId, String key) throws OrderDetailsException, CustomerException, CartException, ItemException;
	
	public OrderDetails updateAddress(Integer addressId, Integer orderId, String key) throws OrderDetailsException, CustomerException, CartException, AddressException;
	
	public OrderDto updateStatus(Integer orderId, String key) throws OrderDetailsException, RestaurantException;
	
	public String cancelOrder(Integer orderId, String key) throws OrderDetailsException, CustomerException;
	
	public OrderDto viewOrder(Integer orderId, String key)throws OrderDetailsException, CustomerException, RestaurantException;
	
	public List<OrderDto> viewAllOrders(String key)throws OrderDetailsException, RestaurantException, CustomerException;
	
	public List<RestOrderDto> viewAllOrdersRestaurant(String key)throws OrderDetailsException, RestaurantException, CustomerException;
	
}