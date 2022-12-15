/**
 * 
 */
package com.foodu.Repsitory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodu.Model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{

}
