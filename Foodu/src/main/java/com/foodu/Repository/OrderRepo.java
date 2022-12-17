package com.foodu.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodu.Model.Address;
import com.foodu.Model.OrderDetails;



public interface OrderRepo extends JpaRepository<OrderDetails, Integer> {
 
	
}
