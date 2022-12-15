package com.foodu.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.foodu.Model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	public List<Item> findByitemName(String itemName);
	
}
