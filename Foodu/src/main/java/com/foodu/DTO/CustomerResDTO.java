package com.foodu.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResDTO {

	private String fullName;
	private Integer age;
	private String gender;

	
}
