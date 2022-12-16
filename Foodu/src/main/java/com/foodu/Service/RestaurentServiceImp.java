package com.foodu.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodu.DTO.GetRestaurantDto;
import com.foodu.DTO.RestaurantDTO;
import com.foodu.Exception.ItemException;
import com.foodu.Exception.RestaurantException;
import com.foodu.Model.Address;
import com.foodu.Model.CurrentUserSession;
import com.foodu.Model.Item;
import com.foodu.Model.Restaurant;
import com.foodu.Repository.AddressRepo;
import com.foodu.Repository.CurrentUserRepo;
import com.foodu.Repository.ItemRepository;
import com.foodu.Repository.RestaurantRepository;


@Service
public class RestaurentServiceImp implements ResturentService{
	
	@Autowired
	private AddressRepo ar;
	
	@Autowired
	private RestaurantRepository rr;
	
	@Autowired
	private ItemRepository ir;
	
	@Autowired
	private CurrentUserRepo sessionrepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Restaurant addRestaurant(RestaurantDTO resDto) throws RestaurantException {
		
		Restaurant restaurant = rr.findByContactNumber(resDto.getContactNumber());
		
		if(restaurant == null) {
			
			restaurant = rr.findByEmail(resDto.getEmail());
			
			if(restaurant == null) {
				
				Restaurant rest  = this.modelMapper.map(resDto, Restaurant.class);
				
				return rr.save(rest);
				
			}else {
				
				throw new RestaurantException("Email already exists..");
				
			}
			
		}else {
			
			throw new RestaurantException("Mobile already exists..");
			
		}
			
		
	}

	
	@Override
	public Restaurant updateRestaurant(RestaurantDTO resDto, String key) throws RestaurantException {
		
		CurrentUserSession curr = sessionrepo.findByUuid(key);
		
		if(curr == null) throw new RestaurantException("No Restaurant Logged in with this key..");
		
		
		
		if(resDto.getRestaurantId() == curr.getUserId()) {
			Restaurant restaurant = rr.findById(resDto.getRestaurantId())
				.orElseThrow(() -> new RestaurantException("No such restaurant exists..."));
			
			restaurant = this.modelMapper.map(resDto, Restaurant.class);
			
			return rr.save(restaurant);
		}else {
			
			throw new RestaurantException("Enter Authorised Restaurant Id..");
			
		}
		
	}

	
	@Override
	public Restaurant removeRestaurant(Integer resId, String key) throws RestaurantException {
		
		CurrentUserSession curr = sessionrepo.findByUuid(key);
		
		if(curr == null) throw new RestaurantException("No Restaurant Logged in with this key..");
		
		
		
		if(resId == curr.getUserId()) {
			Restaurant restaurant = rr.findById(resId)
				.orElseThrow(() -> new RestaurantException("No such restaurant exists..."));
			
			rr.delete(restaurant);
		
			return restaurant;
		
		}else {
			
			throw new RestaurantException("Enter Authorised Restaurant Id..");
			
		}

	}

	



	@Override
	public GetRestaurantDto viewRestaurant(Integer resId) throws RestaurantException {
		Restaurant restaurant = rr.findById(resId)
				.orElseThrow(() -> new RestaurantException("No such restaurant exists..."));
			
		return this.modelMapper.map(restaurant, GetRestaurantDto.class);
	}


	@Override
	public List<GetRestaurantDto> viewNearByRestaurant(String city) throws RestaurantException {
		// TODO Auto-generated method stub
		return null;
	}


	public Set<GetRestaurantDto> viewRestaurantByItemName(String itemName) throws ItemException, RestaurantException{
	
	Set<Restaurant> itms = rr.findByRestaurantName(itemName);
	
//	System.out.println(itms);
	
	if(itms.size() == 0) {
		throw new ItemException("No such item exists...");
	}
	
	Set<GetRestaurantDto> rDtos = new HashSet<>();


	for(Restaurant i : itms) {

		GetRestaurantDto rDto = this.modelMapper.map(i.getRestaurantId(), GetRestaurantDto.class);
		
	    rDtos.add(rDto);
	}
	
	if(rDtos.isEmpty())
		throw new RestaurantException("No Restaurants Had this Item ");
	
	return rDtos;
}


	
}
