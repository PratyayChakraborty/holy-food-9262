package com.foodu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodu.Exception.CategoryException;
import com.foodu.Exception.ItemException;
import com.foodu.Exception.RestaurantException;
import com.foodu.Model.Category;
import com.foodu.Model.Item;
import com.foodu.Model.Restaurant;

public interface ItemServiceDAO {
	
	
	public Item addItems (Item item) throws ItemException;
	
	public Item updateItem (Item item) throws ItemException;
	
	public Item viewItem (Integer itemId)throws ItemException;
	
	public Item removeItem (Integer itemId)throws ItemException;
	
	public List<Item> viewAllItems (Category cat)throws CategoryException;
	
	public List<Item> viewAllItems (Restaurant rest)throws RestaurantException;
	
	public List<Item> viewAllItemsByName (String itemName)throws ItemException;
	
	
	
	

}
