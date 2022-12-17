package com.foodu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodu.Model.Item;


@Repository
public interface RestaurantDtoRepo extends JpaRepository<Item, Integer> {

}
