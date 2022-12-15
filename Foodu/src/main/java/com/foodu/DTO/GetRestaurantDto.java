package com.foodu.DTO;

import java.util.ArrayList;
import java.util.List;

import com.foodu.Model.Address;
import com.foodu.Model.Item;

import lombok.Data;

@Data
public class GetRestaurantDto {

	private Integer restaurantId;
	private String restaurantName;
	private String contactNumber;
	private Address address;
	
	private List<Item> itemList = new ArrayList<>();
	
}
