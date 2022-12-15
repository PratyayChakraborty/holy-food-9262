package com.foodu.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodu.Model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{

}
