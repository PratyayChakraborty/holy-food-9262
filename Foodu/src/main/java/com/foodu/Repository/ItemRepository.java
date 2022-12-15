package com.foodu.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodu.Model.Category;
import com.foodu.Model.Item;
import com.foodu.Model.Restaurant;

public interface ItemRepository extends JpaRepository<Item, Integer>{


	@Query("select i.restaurant from Item i where i.itemName like %?1%")
	public List<Restaurant> searchByItemNameContaining(String itemName);
	

	public List<Item> findByItemNameContaining(String itemName);

	public List<Item> findByItemName(String itemName);

	public List<Item> findByCategory(Category category);
	
}
