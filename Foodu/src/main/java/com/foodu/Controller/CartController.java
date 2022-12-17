package com.foodu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodu.Exception.CartException;
import com.foodu.Exception.ItemException;
import com.foodu.Exception.RestaurantException;
import com.foodu.Model.FoodCart;
import com.foodu.Service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService carts;
	
	

	@PutMapping("/add") 
	public ResponseEntity<FoodCart> addItemToCartHandler(@RequestParam Integer itemId, @RequestParam String key)
			throws RestaurantException, ItemException {

		FoodCart fc = carts.addItemToCart(itemId, key);

		return new ResponseEntity<FoodCart>(fc, HttpStatus.ACCEPTED);

	}

	@PutMapping("/increase") 
	public ResponseEntity<FoodCart> increaseQuantityHandler(@RequestParam Integer itemId,
			@RequestParam Integer Quantity, @RequestParam String key)
			throws RestaurantException, ItemException, CartException {

		FoodCart fc = carts.increaseQuantity(itemId, Quantity, key);

		return new ResponseEntity<FoodCart>(fc, HttpStatus.OK);
	}

	@PutMapping("/reduce") 
	public ResponseEntity<FoodCart> reduceQuantityHandler(@RequestParam Integer itemId, @RequestParam Integer Quantity,
			@RequestParam String key) throws RestaurantException, ItemException, CartException {

		FoodCart fc = carts.reduceQuantity(itemId, Quantity, key);

		return new ResponseEntity<FoodCart>(fc, HttpStatus.OK);
	}

	@DeleteMapping("/remove") 
	public ResponseEntity<FoodCart> removeHandler(@RequestParam Integer itemId, @RequestParam String key)
			throws RestaurantException, ItemException, CartException {

		FoodCart fc = carts.removeItem(itemId, key);

		return new ResponseEntity<FoodCart>(fc, HttpStatus.OK);
	}

	@DeleteMapping("/clear") 
	public ResponseEntity<String> clearcartHandler(@RequestParam String key)
			throws RestaurantException, CartException {

		String fc = carts.clearCart(key);

		return new ResponseEntity<String>(fc, HttpStatus.OK);
	}
	
	
	@GetMapping("/view")
	public ResponseEntity<FoodCart> viewCartHandler(@RequestParam String key)
			throws RestaurantException, CartException {

		FoodCart fc = carts.viewCart(key);

		return new ResponseEntity<FoodCart>(fc, HttpStatus.OK);
	}
	
	
	
	
}
