package com.foodu.Service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodu.DTO.GetRestaurantDto;
import com.foodu.DTO.RestaurantDTO;
import com.foodu.DTO.RestaurantItemDto;
import com.foodu.Exception.ItemException;
import com.foodu.Exception.RestaurantException;
import com.foodu.Model.Address;
import com.foodu.Model.CurrentUserSession;
import com.foodu.Model.Item;
import com.foodu.Model.Restaurant;
import com.foodu.Repository.AddressRepo;
import com.foodu.Repository.CategoryRepository;
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
	
	private CategoryRepository cr;
	
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
		List<Address> itms = ar.findByCity(city);
		
		System.out.println(itms);
		
		if(itms.size() == 0) {
			throw new ItemException("No restaurant found in "+city);
		}
		
		List<GetRestaurantDto> rDtos = new ArrayList<>();


		for(Address a : itms) {

			GetRestaurantDto rDto = this.modelMapper.map(rr.findByAddress(a), GetRestaurantDto.class);
			
		    rDtos.add(rDto);
		}
		
		if(rDtos.isEmpty())
			throw new ItemException("No restaurant found in "+city);
		
		return rDtos;
	}


	public Set<GetRestaurantDto> viewRestaurantByItemName(String itemName) throws ItemException, RestaurantException{

	List<Item> itms = ir.findByitemName(itemName);
	
	System.out.println(itms);
	
	if(itms.size() == 0) {
		throw new ItemException("No such item exists...");
	}
	
	Set<GetRestaurantDto> rDtos = new HashSet<>();


	for(Item i : itms) {

		GetRestaurantDto rDto = this.modelMapper.map(i.getRestaurant(), GetRestaurantDto.class);
		
	    rDtos.add(rDto);
	}
	
	if(rDtos.isEmpty())
		throw new RestaurantException("No Restaurants Had this Item ");
	
	return rDtos;
}


	@Override
	public String addItemToResaurant(RestaurantItemDto RsI) throws ItemException, RestaurantException {

		CurrentUserSession cru =sessionrepo.findByUuid(RsI.getKey());
		if(cru!=null) {

			Optional<Restaurant> res=rr.findById(cru.getUserId());
			
			if(!res.isEmpty()) {

				Restaurant r=res.get();
				

				
				List<Item> htoadd=RsI.getItemlist();
				
				for(Item h:htoadd) {
					h.setRestaurant(r);
//					ri.add(h);
//					cr.save(h.getCategory());
					
					r.getItemList().add(h);
				}
				
				
				rr.save(r);
				}
			else {

				throw new RestaurantException("There is no User With this id");
			}
			
		}
		else {

			throw new RestaurantException("There is no User With this id");
		}
		return "Item Sucssesfully added";
	}


	
}
