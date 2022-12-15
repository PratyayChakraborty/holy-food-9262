package com.foodu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodu.Model.OrderDetails;



public interface OrderRepo extends JpaRepository<OrderDetails, Integer> {

}
