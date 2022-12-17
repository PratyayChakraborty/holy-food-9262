package com.foodu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.foodu.Model.OrderItems;


public interface OrderItemsRepo extends JpaRepository<OrderItems, Integer> {

	

}
