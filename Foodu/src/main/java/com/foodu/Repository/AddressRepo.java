package com.foodu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodu.Model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
