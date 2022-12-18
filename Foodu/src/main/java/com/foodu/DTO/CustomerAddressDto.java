package com.foodu.DTO;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.foodu.Model.Address;
import com.foodu.Model.FoodCart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddressDto {
	
	private Integer customerId;
	
	@Size(min = 3, message = "Customer Name is Mandatory")
	private String fullName;
	
	@Min (12)
	@Max (100)
	private Integer age;
	
	@NotBlank(message = "Customer Name is Mandatory")
	private String gender;
	
	@NotBlank
	@Size(min = 10, max = 12, message = "mobile must be between 10 to 12 digit")
	private String mobileNumber;
	
	@NotBlank
	@Email(message = "Give proper Email Id")
	private String email;
	
	@NotBlank
	@Size(min = 6, message = "Password Size must be greater than 6")
	private String password;
	
	
	private Set<Address> addresses = new HashSet<>();
	
	@JsonIgnore
	private FoodCart fc =new FoodCart();

}
