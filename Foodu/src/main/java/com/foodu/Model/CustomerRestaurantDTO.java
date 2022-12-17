package com.foodu.Model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerRestaurantDTO {
	
	private String fullName;
	private Integer age;
	private String gender;

	private List<OrderDetails> orders;

	public CustomerRestaurantDTO(String fullName, Integer age, String gender) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
	}

}
