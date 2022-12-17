package com.foodu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.foodu.Model.Customer;
import com.foodu.Model.Restaurant;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	public Customer findByMobileNumber(String number);
	
	public Customer findByEmail(String email);
	

}
