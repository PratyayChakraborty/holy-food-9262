package com.foodu.Repository;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodu.Model.Address;
import com.foodu.Model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
	
	public Set<Restaurant> findByRestaurantName(String restaurantName);
	public Restaurant findByAddress(Address address);
	
	public Restaurant findByContactNumber(String number);
	
	public Restaurant findByEmail(String email);

	
}
