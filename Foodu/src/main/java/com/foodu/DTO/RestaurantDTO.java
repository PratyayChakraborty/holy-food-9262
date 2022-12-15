package com.foodu.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.foodu.Model.Address;
import com.foodu.Model.Item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class RestaurantDTO {
	private Integer restaurantId;
	
	@NotBlank(message = "Restaurant Name is Mandatory")
	private String restaurantName;
	
	@Size(min = 3, message = "manager Name is Mandatory")
	private String managerName;
	
	@NotBlank
	@Size(min = 10, max = 12, message = "mobile must be between 10 to 12 digit")
	private String contactNumber;
	
	@NotBlank
	@Email(message = "Give proper Email Id")
	private String email;
	
	@NotBlank
	@Size(min = 6, message = "Password Size must be greater than 6")
	private String password;
	
	@Valid
	private Address address;
}
