package com.foodu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodu.Model.Restaurant;

public interface RestaurantRepo  extends JpaRepository<Restaurant, Integer>{

}
