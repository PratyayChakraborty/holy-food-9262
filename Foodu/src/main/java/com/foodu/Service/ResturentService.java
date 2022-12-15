package com.foodu.Service;

import java.util.List;
import java.util.Set;

import com.foodu.DTO.GetRestaurantDto;
import com.foodu.DTO.RestaurantDTO;
import com.foodu.Exception.ItemException;
import com.foodu.Exception.RestaurantException;
import com.foodu.Model.Restaurant;

public interface ResturentService {

	public Restaurant addRestaurant(RestaurantDTO res) throws RestaurantException;
	
	public Restaurant updateRestaurant(RestaurantDTO res, String key) throws RestaurantException;
	
	public Restaurant removeRestaurant(Integer resId, String key) throws RestaurantException;
	
	public GetRestaurantDto viewRestaurant(Integer resId) throws RestaurantException;
	
	public List<GetRestaurantDto> viewNearByRestaurant(String city) throws RestaurantException;
	
	public Set<GetRestaurantDto> viewRestaurantByItemName(String name) throws ItemException, RestaurantException;
	
}
