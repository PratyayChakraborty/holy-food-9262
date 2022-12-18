package com.foodu.DTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.foodu.Model.FoodCart;
import com.foodu.Model.Item;

public class FoodCartItemDto {

	private Integer id;
	

	private FoodCart fc;
	
	
	private Item item;
	
	private Integer quantity;
	
	
}
