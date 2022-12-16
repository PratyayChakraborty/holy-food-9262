package com.foodu.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.foodu.Exception.BillException;
import com.foodu.Model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{

	@Query("select b from Bill b where billDate between :startDate and :endDate")
	public List<Bill> viewBillsByDates(@Param("startDate")LocalDate startDate,@Param("startDate") LocalDate endDate) throws BillException;
	
}
