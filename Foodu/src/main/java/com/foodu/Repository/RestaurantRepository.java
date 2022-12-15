package com.foodu.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodu.Model.Address;
import com.foodu.Model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
	public List<Restaurant> findByRestaurantName(String restaurantName);
	
	public Restaurant findByAddress(Address address);
	
	public Restaurant findByContactNumber(String number);
	
	public Restaurant findByEmail(String email);

	
}
