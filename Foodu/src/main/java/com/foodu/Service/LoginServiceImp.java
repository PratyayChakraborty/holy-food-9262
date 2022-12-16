package com.foodu.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodu.DTO.LogInDto;
import com.foodu.DTO.RestaurantDTO;
import com.foodu.Exception.LoginException;
import com.foodu.Model.CurrentUserSession;
import com.foodu.Model.Customer;
import com.foodu.Model.Login;
import com.foodu.Model.Restaurant;
import com.foodu.Repository.CurrentUserRepo;
import com.foodu.Repository.RestaurantRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImp implements LoginService {
	
	@Autowired
	private RestaurantRepository rr;
	@Autowired
	private CurrentUserRepo cus;

	@Override
	public String logIntoAccount(LogInDto dto) throws LoginException {
		
		String role=dto.getRole();
		
		if(role.equalsIgnoreCase("Restaurant")) {
		
		Restaurant existingRes = rr.findByContactNumber(dto.getMobileNo());

		if (existingRes == null) {

			throw new LoginException("Please Enter a valid mobile number");

		}

		Optional<CurrentUserSession> validCustomerSessionOpt = cus.findById(existingRes.getRestaurantId());

		if (validCustomerSessionOpt.isPresent()) {

			throw new LoginException("User already Logged In with this number");

		}

		if (existingRes.getPassword().equals(dto.getPassword())) {

			String key = RandomString.make(4);

			CurrentUserSession currentUser = new CurrentUserSession(existingRes.getRestaurantId(), key,dto.getRole(), LocalDateTime.now());

			cus.save(currentUser);

			return "Login Succsessfull :"+currentUser.toString();
		} else
			throw new LoginException("Please Enter a valid password");
		
		}else if(role.equalsIgnoreCase("Customer")) {
			
			
			return "Login Succsessfull :";
			
		}else {
			return "give valid user";
			
		}
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
CurrentUserSession validCustomerSession = cus.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		cus.delete(validCustomerSession);
		
		
		return "Logged Out !";
	}

}
