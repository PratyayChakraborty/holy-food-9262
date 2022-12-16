package com.foodu.Service;

import com.foodu.DTO.LogInDto;
import com.foodu.Exception.LoginException;
import com.foodu.Model.Login;

public interface LoginService {
			
	public String logIntoAccount(LogInDto dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;
	
	
}
