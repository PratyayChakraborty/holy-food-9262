package com.foodu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodu.Exception.ItemException;
import com.foodu.Model.Item;
import com.foodu.Service.ItemServiceDAO;

@RestController
public class ItemHandler {
	
	@Autowired
	private ItemServiceDAO itemServiceDAO;
	
	@PostMapping("/items")
	public ResponseEntity<Item> addItemsHandler(@RequestBody Item item) throws ItemException {
	Item item1=	itemServiceDAO.addItems(item);

		return new ResponseEntity<Item>(item1, HttpStatus.CREATED);
	
	}
	
	@PutMapping("/updateitem")
	public ResponseEntity<Item> updateItemHandler(@RequestBody Item item) throws ItemException{
		Item item2=	itemServiceDAO.updateItem(item);
		
		return new ResponseEntity<Item>(item2, HttpStatus.OK);
		
	}
	
	@GetMapping("/itemgetbyid/{itemId}")
	public ResponseEntity<Item> viewItemHandler(@PathVariable ("itemId") Integer itemId) throws ItemException{
		Item item3=	itemServiceDAO.viewItem(itemId);
		return new ResponseEntity<Item>(item3, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/itemdeletebyid/{itemId}")
	public ResponseEntity<Item> removeItem(@PathVariable ("itemId") Integer itemId) throws ItemException {
		
		Item item4=	itemServiceDAO.removeItem(itemId);
		
		return new ResponseEntity<Item>(item4, HttpStatus.OK);
	}
	
	@GetMapping("/itemsgetbyname/{itemName}")
	public ResponseEntity<List<Item>> viewAllItemsByName( @PathVariable ("itemName") String itemName) throws ItemException {
		List<Item> item7=	itemServiceDAO.viewAllItemsByName(itemName);
		
		return new ResponseEntity<List<Item>>(item7, HttpStatus.OK);

	}
}
