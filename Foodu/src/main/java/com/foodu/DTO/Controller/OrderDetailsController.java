package com.foodu.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodu.Exception.OrderException;
import com.foodu.Model.Address;
import com.foodu.Model.Bill;
import com.foodu.Model.Customer;
import com.foodu.Model.OrderDetails;
import com.foodu.Model.OrderItems;
import com.foodu.Model.Restaurant;
import com.foodu.Service.OrderService;

@RestController
public class OrderDetailsController {
	
	@Autowired
	private OrderService orderService;
	
//	@Autowired
//	private Restaurant resturent;	
//	private Customer customer;
	
	@PutMapping("/orderdetails/{id}")
	public ResponseEntity<OrderDetails> addOrderHandler(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OrderDetails order, @PathVariable("id") Integer id) throws OrderException {
		   
		  Customer cust = orderService.GetCustomer(id);
		  Set<Address> addList = cust.getAddresses();
		  List<Address> listAddr = new ArrayList<Address>(addList);		
		  order.setCustomer(cust);
		  if(listAddr.size() != 0) {
		  order.setOrderAddress(listAddr.get(0));
		  }else {
			  order.setOrderAddress(null);
		  }
		  
		  List<OrderDetails> orderList = orderService.getOrderDetailsFromCustomerID(id);
		  Integer OrderId = orderList.get(orderList.size()-1).getOrderId();
		  Bill bill = orderService.GetBill(OrderId);
		  order.setBill(bill);

		  Restaurant rest = orderService.getRestaurant(id);
		  order.setRestaurant(rest);
		 
		  OrderDetails od = orderService.addOrder(order);
          return new ResponseEntity<OrderDetails>(od,HttpStatus.CREATED);
	} 
    
	@PutMapping("/orderdetails")
	public ResponseEntity<OrderDetails>  updateOrderHandler(@RequestBody @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME) OrderDetails order) throws OrderException{
		  OrderDetails od = orderService.updateOrder(order);
          return new ResponseEntity<OrderDetails>(od,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("orderdetails/{id}")
	public ResponseEntity<OrderDetails> removeProductHandler(Integer id) throws OrderException{

		return new ResponseEntity<OrderDetails>(orderService.removeOrder(id),HttpStatus.OK);
		
	}
	
	
	@GetMapping("/allorder")
	public ResponseEntity<List<OrderDetails>> viewAllOrderHandler() throws OrderException{
		
		List<OrderDetails>orderList = orderService.viewAllOrder();
		return new ResponseEntity<List<OrderDetails>>(orderList,HttpStatus.FOUND);
	}
	
//	@GetMapping("/allresturentorder")
//	public ResponseEntity<List<OrderDetails>> viewAllResurentOrderHandler() throws OrderException{
//		List<OrderDetails> olist = orderService.viewAllOrders(resturent);
//		return new ResponseEntity<List<OrderDetails>>(olist,HttpStatus.FOUND);
//		
//		
//	}
//	
//	
//	@GetMapping("/allcustomerorder")
//	public ResponseEntity<List<OrderDetails>> viewAllResurentCustomerHandler() throws OrderException{
//		List<OrderDetails> olist = orderService.viewAllOrders(customer);
//		return new ResponseEntity<List<OrderDetails>>(olist,HttpStatus.FOUND);
//		
//	}
	
	
	
    
	
	
	
	
}