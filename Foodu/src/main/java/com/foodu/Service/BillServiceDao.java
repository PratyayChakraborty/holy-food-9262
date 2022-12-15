package com.foodu.Service;

import java.time.LocalDate;
import java.util.List;

import com.foodu.Exception.BillException;
import com.foodu.Model.Bill;





public interface BillServiceDao {
   
	public Bill addBill(Bill bill);
	
//	public Bill updateBill(Bill bill)throws BillException;
//	
//	public Bill removeBill(Bill bill)throws BillException;
//	
//	public Bill veiwBill (int billid)throws BillException;
//	
//	public List<Bill> viewBillsByDate(LocalDate startDate, LocalDate endDate )throws BillException;
//	
//	public List<Bill> viewBillsByCusomer(int customerId)throws BillException;
//	
//	public Double calculateTotalCost(Bill bill)throws BillException;
//	
}
