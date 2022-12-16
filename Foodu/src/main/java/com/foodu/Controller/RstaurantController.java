package com.foodu.Controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodu.DTO.GetRestaurantDto;
import com.foodu.DTO.RestaurantDTO;
import com.foodu.DTO.RestaurantItemDto;
import com.foodu.Exception.RestaurantException;
import com.foodu.Model.Restaurant;
import com.foodu.Service.ResturentService;

//#swagger-url: http://localhost:8888/swagger-ui

@RestController
@RequestMapping("/restaurant")
public class RstaurantController {

	@Autowired
	private ResturentService resServ;

	@GetMapping("/getbodyRe")
	public Restaurant getbody() {

		return new Restaurant();
	}

	// --------Basic Restaurant operation----------//
	@PostMapping("/create")
	public ResponseEntity<Restaurant> addRestaurant(@Valid @RequestBody RestaurantDTO resDto)
			throws RestaurantException {

		Restaurant rest = resServ.addRestaurant(resDto);

		return new ResponseEntity<Restaurant>(rest, HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<Restaurant> updateRestaurant(@Valid @RequestBody RestaurantDTO res, @RequestParam String key)
			throws RestaurantException {
		Restaurant rest = resServ.updateRestaurant(res, key);

		return new ResponseEntity<Restaurant>(rest, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<Restaurant> removeRestaurant(@RequestParam Integer resId, @RequestParam String key)
			throws RestaurantException {
		Restaurant rest = resServ.removeRestaurant(resId, key);

		return new ResponseEntity<Restaurant>(rest, HttpStatus.OK);
	}

	@GetMapping("/viewRestaurentbyId/{resId}")
	public ResponseEntity<GetRestaurantDto> viewRestaurentbyId(@PathVariable("resId") Integer resId)
			throws RestaurantException {
		
		GetRestaurantDto rest=resServ.viewRestaurant(resId);
			return new ResponseEntity<GetRestaurantDto>(rest,HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/viewRestaurentbyitemName/{itemName}")
	public ResponseEntity<Set<GetRestaurantDto>> viewRestaurentbyName(@RequestParam("itemName") String itemName)
			throws RestaurantException {
		
		Set<GetRestaurantDto>  rest=resServ.viewRestaurantByItemName(itemName);
			return new ResponseEntity<Set<GetRestaurantDto> >(rest,HttpStatus.ACCEPTED);
	}
	@PutMapping("/additems")
	public ResponseEntity<String> addItemsInRes(@RequestBody RestaurantItemDto resIdto){
		
		String s=resServ.addItemToResaurant(resIdto);
		
		
		
		return new ResponseEntity<String>(s,HttpStatus.ACCEPTED);
		
	}
	
	
}
