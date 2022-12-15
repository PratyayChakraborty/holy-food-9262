package com.foodu.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodu.Exception.CategoryException;
import com.foodu.Exception.ItemException;
import com.foodu.Exception.RestaurantException;
import com.foodu.Model.Category;
import com.foodu.Model.Item;
import com.foodu.Model.Restaurant;
import com.foodu.Repository.ItemRepository;

@Service
public class ItemServiceDAOImpl implements ItemServiceDAO{

	@Autowired
	private ItemRepository itemRepository;
	
	
	@Override
	public Item addItems(Item item) throws ItemException {
	Item item1=	itemRepository.save(item);
	if(item1==null) {
		throw new ItemException("Item not added");
	}
		return item1;
	}

	@Override
	public Item updateItem(Item item) throws ItemException {
		Item item2 = itemRepository.findById(item.getItemId()).orElseThrow(()->new ItemException("Item not find with this ItemId"+item.getItemId()));
		if(item2!=null) {
			itemRepository.save(item2);
		}
		return item;
	}

	@Override
	public Item viewItem(Integer itemId) throws ItemException {
	return	itemRepository.findById(itemId).orElseThrow(()-> new ItemException("Item not find with this itemId"+itemId));
		
	}

	@Override
	public Item removeItem(Integer itemId) throws ItemException {
	Item item3=	itemRepository.findById(itemId).orElseThrow(()-> new ItemException("Item not find with thid id"+itemId));
		if(item3 !=null) {
		itemRepository.delete(item3);
		}
		return item3;
		
	}

	@Override
	public List<Item> viewAllItems(Category cat) throws CategoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> viewAllItems(Restaurant rest) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> viewAllItemsByName(String itemName) throws ItemException {
		List<Item> item7 = itemRepository.findByitemName(itemName);
		if(item7==null) {
			throw new ItemException("Item not added");	
		}
		
		return item7;
	}

	

}
