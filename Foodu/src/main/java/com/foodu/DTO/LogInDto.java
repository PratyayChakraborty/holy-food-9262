package com.foodu.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LogInDto {

	private String mobileNo;
	private String password;
	
	private String role;
	
	
}
