package com.foodu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.foodu.Model.Customer;


public interface CustomerRepogitory extends JpaRepository<Customer, Integer>{

}
