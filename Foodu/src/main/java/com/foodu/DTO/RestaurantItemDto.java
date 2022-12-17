package com.foodu.DTO;

import java.util.ArrayList;
import java.util.List;

import com.foodu.Model.Item;

import lombok.Data;

@Data
public class RestaurantItemDto {
	
	
	private String key;
	List<Item> itemlist=new ArrayList<>();
	 
	
}
