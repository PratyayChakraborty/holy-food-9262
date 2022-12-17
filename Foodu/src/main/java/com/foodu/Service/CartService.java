package com.foodu.Service;

import com.foodu.Exception.CartException;
import com.foodu.Exception.ItemException;
import com.foodu.Exception.RestaurantException;
import com.foodu.Model.FoodCart;

public interface CartService {

	public FoodCart addItemToCart(Integer itemId, String key) throws RestaurantException, ItemException;

	public FoodCart increaseQuantity(Integer itemId, Integer quantity, String key) throws RestaurantException, ItemException, CartException;

	public FoodCart reduceQuantity(Integer itemId, Integer quantity, String key) throws RestaurantException, ItemException, CartException;

	public FoodCart removeItem(Integer itemId, String key) throws RestaurantException, ItemException, CartException;

	public String clearCart(String key) throws RestaurantException, CartException;
	
	public FoodCart viewCart(String key) throws RestaurantException, CartException;
}

