package com.foodu.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodu.Exception.CartException;
import com.foodu.Exception.ItemException;
import com.foodu.Exception.RestaurantException;
import com.foodu.Model.CurrentUserSession;
import com.foodu.Model.Customer;
import com.foodu.Model.FoodCart;
import com.foodu.Model.FoodCartItems;
import com.foodu.Model.Item;
import com.foodu.Repository.CurrentUserRepo;
import com.foodu.Repository.CustomerRepository;
import com.foodu.Repository.FoodCartItemRepo;
import com.foodu.Repository.FoodCartRepo;
import com.foodu.Repository.ItemRepository;



@Service
public class CartServiceImp implements CartService {


	@Autowired
	private ItemRepository itemDao;
	
	@Autowired
	private FoodCartRepo fcr;

	@Autowired
	private CurrentUserRepo sessionrepo;
	
	@Autowired
	private CustomerRepository customerrepo;
	
	@Autowired
	private FoodCartItemRepo fcir;
	
	
	
	@Override
	public FoodCart addItemToCart(Integer itemId, String key) throws RestaurantException, ItemException {
		
		CurrentUserSession curr = sessionrepo.findByUuid(key);
		
		if(curr == null) throw new RestaurantException("No Customer Logged in with this key..");
		
		if(curr.getRole().equalsIgnoreCase("restaurant")) throw new RestaurantException("You are not authorized..");
		
		Customer customer = customerrepo.findById(curr.getUserId())
				.orElseThrow(() -> new RestaurantException(""));
		
		Item item = itemDao.findById(itemId)
			.orElseThrow(() ->new ItemException("Item id not valid!!!"));
		
		FoodCart fc = customer.getFoodCart();
		
		System.out.println("hi");
		
		List<FoodCartItems> fciList =fc.getItemList();
		
		
		FoodCartItems fci = fcir.sameItem(fc, item);

		
		if(fci == null) {
			
			fci = new FoodCartItems();
			
			fci.setFc(fc);
			fci.setItem(item);
			fci.setQuantity(1);	
			
			fciList.add(fci);
			
			fc.setItemList(fciList);
			
			fcr.save(fc);
			
		}else {
			Integer quan = fci.getQuantity();
			
			fci.setQuantity(quan + 1);
		}
		
		customerrepo.save(customer);
		
		return fc;
	
	}


	@Override
	public FoodCart increaseQuantity(Integer itemId, Integer quantity, String key) throws RestaurantException, ItemException, CartException {

		CurrentUserSession curr = sessionrepo.findByUuid(key);
		
		if(curr == null) throw new RestaurantException("No Customer Logged in with this key..");
		
		if(curr.getRole().equalsIgnoreCase("restaurant")) throw new RestaurantException("You are not authorized..");
		
		Customer customer = customerrepo.findById(curr.getUserId())
				.orElseThrow(() -> new RestaurantException(""));
		
		Item item = itemDao.findById(itemId)
				.orElseThrow(() -> new ItemException("There is no Item with this Id.."));

		FoodCartItems fci = fcir.sameItem(customer.getFoodCart(), item);
		
		if(fci == null) {
			throw new CartException("First Add the item in your cart");
		}
		
		Integer quan = fci.getQuantity();
		
		fci.setQuantity(quan + quantity);
		
		customerrepo.save(customer);

		return customer.getFoodCart();
	}
	
	
	
	@Override
	public FoodCart reduceQuantity(Integer itemId, Integer quantity, String key) throws RestaurantException, ItemException, CartException{
		
		CurrentUserSession curr = sessionrepo.findByUuid(key);
		
		if(curr == null) throw new RestaurantException("No Customer Logged in with this key..");
		
		if(curr.getRole().equalsIgnoreCase("restaurant")) throw new RestaurantException("You are not authorized..");
		
		Customer customer = customerrepo.findById(curr.getUserId())
				.orElseThrow(() -> new RestaurantException(""));
		
		Item item = itemDao.findById(itemId)
				.orElseThrow(() -> new ItemException("There is no Item with this Id.."));

		FoodCartItems fci = fcir.sameItem(customer.getFoodCart(), item);
		
		if(fci == null) {
			throw new CartException("First Add the item in your cart");
		}
		
		Integer quan = fci.getQuantity();
		
		fci.setQuantity(quan - quantity);
		
		customerrepo.save(customer);

		return customer.getFoodCart();

	}
	
	
	
	@Override
	public FoodCart removeItem(Integer itemId, String key) throws RestaurantException, ItemException, CartException{
	
		CurrentUserSession curr = sessionrepo.findByUuid(key);
		
		if(curr == null) throw new RestaurantException("No Customer Logged in with this key..");
		
		if(curr.getRole().equalsIgnoreCase("restaurant")) throw new RestaurantException("You are not authorized..");
		
		Customer customer = customerrepo.findById(curr.getUserId())
				.orElseThrow(() -> new RestaurantException(""));
		
		Item item = itemDao.findById(itemId)
				.orElseThrow(() -> new ItemException("There is no Item with this Id.."));

		FoodCartItems fci = fcir.sameItem(customer.getFoodCart(), item);
		
		if(fci == null) {
			throw new CartException("This Item is added in your cart");
		}
		
		customer.getFoodCart().getItemList().remove(fci);
		
		fcir.delete(fci);

		return customer.getFoodCart();
		
	}
	
	
	@Override
	public String clearCart(String key) throws RestaurantException, CartException {
		
		CurrentUserSession curr = sessionrepo.findByUuid(key);
		
		if(curr == null) throw new RestaurantException("No Customer Logged in with this key..");
		
		if(curr.getRole().equalsIgnoreCase("restaurant")) throw new RestaurantException("You are not authorized..");
		
		Customer customer = customerrepo.findById(curr.getUserId())
				.orElseThrow(() -> new RestaurantException(""));

		List<FoodCartItems> fci = fcir.findByFc(customer.getFoodCart());
		
		if(fci.size() == 0) {
			throw new CartException("Your Cart is Already Empty..");
		}
		
		customer.getFoodCart().getItemList().clear();
		
		System.out.println(customer.getFoodCart().getItemList());
		
		for(FoodCartItems fcit: fci) {
			fcir.delete(fcit);
		}
		
		return "Cart Successfull Cleared..";
	}


	@Override
	public FoodCart viewCart(String key) throws RestaurantException, CartException {
		
		CurrentUserSession curr = sessionrepo.findByUuid(key);
		
		if(curr == null) throw new RestaurantException("No Customer Logged in with this key..");
		
		if(curr.getRole().equalsIgnoreCase("restaurant")) throw new RestaurantException("You are not authorized..");
		
		Customer customer = customerrepo.findById(curr.getUserId())
				.orElseThrow(() -> new RestaurantException(""));
		
		return customer.getFoodCart();
		
	}


}

