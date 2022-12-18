package com.foodu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodu.DTO.OrderDto;
import com.foodu.Exception.AddressException;
import com.foodu.Exception.CartException;
import com.foodu.Exception.CustomerException;
import com.foodu.Exception.ItemException;
import com.foodu.Exception.OrderDetailsException;
import com.foodu.Exception.RestaurantException;
import com.foodu.Model.OrderDetails;
import com.foodu.Service.CategoryServiceDAO;
import com.foodu.Service.OrderDetailsService;

@RestController
@RequestMapping("/order")
public class OrderDetailsController {
	
	@Autowired
	private OrderDetailsService or;
	
	
//	private CategoryServiceDAO cts;
	
	
	
	@PostMapping("/add") 
	public ResponseEntity<OrderDetails> addDetailsHandller(@RequestParam Integer addressId, @RequestParam String key)
			throws OrderDetailsException, CustomerException, AddressException, CartException {

		System.out.println("hi");

		OrderDetails dt = or.addDetails(addressId, key);

		return new ResponseEntity<OrderDetails>(dt, HttpStatus.OK);

	}

	@PutMapping("/updateitem") 
	public ResponseEntity<OrderDetails> updataDetailsupdateItem(@RequestParam Integer itemId,
			@RequestParam Integer orderId, @RequestParam String key)
			throws OrderDetailsException, CustomerException, CartException, ItemException {

		OrderDetails dtt = or.updateItem(itemId, orderId, key);

		return new ResponseEntity<OrderDetails>(dtt, HttpStatus.OK);

	}

	@PutMapping("/updateaddress")
	public ResponseEntity<OrderDetails> updateAddress(@RequestParam Integer addressId, @RequestParam Integer orderId,
			@RequestParam String key) throws OrderDetailsException, CustomerException, CartException, AddressException {

		OrderDetails dt = or.updateAddress(addressId, orderId, key);

		return new ResponseEntity<OrderDetails>(dt, HttpStatus.OK);

	}

	@DeleteMapping("/cancel") 
	public ResponseEntity<String> cancelOrder(@RequestParam Integer orderId, @RequestParam String key)
			throws OrderDetailsException, CustomerException {

		String str = or.cancelOrder(orderId, key);

		return new ResponseEntity<String>(str, HttpStatus.OK);
	}

	@GetMapping("/id") 
	public ResponseEntity<OrderDto> viewOrder(@RequestParam Integer orderId, @RequestParam String key)
			throws OrderDetailsException, CustomerException, RestaurantException {

		OrderDto dt = or.viewOrder(orderId, key);

		return new ResponseEntity<OrderDto>(dt, HttpStatus.OK);
	}

	@GetMapping("/viewall") 
	public ResponseEntity<List<OrderDto>> viewAllOrders(@RequestParam String key)
			throws OrderDetailsException, CustomerException, RestaurantException {

		List<OrderDto> dt = or.viewAllOrders(key);

		return new ResponseEntity<List<OrderDto>>(dt, HttpStatus.OK);
	}



	
	
}
