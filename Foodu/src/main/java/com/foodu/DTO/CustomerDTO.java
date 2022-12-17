package com.foodu.DTO;

import java.util.HashSet;
import java.util.Set;

import com.foodu.Model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
	
	private Integer customerId;
	private String fullName;
	private Integer age;
	private String gender;
	private String mobileNumber;
	private String email;
	
	private Set<Address> addresses = new HashSet<>();

}
