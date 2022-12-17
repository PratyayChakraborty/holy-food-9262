package com.foodu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodu.Model.FoodCart;

@Repository
public interface FoodCartRepo extends JpaRepository<FoodCart, Integer>{

}
