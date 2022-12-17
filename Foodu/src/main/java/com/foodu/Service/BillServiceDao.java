package com.foodu.Service;

import java.time.LocalDate;
import java.util.List;

import com.foodu.Exception.BillException;
import com.foodu.Model.Bill;

public interface BillServiceDao {
	
	public Bill addBill(Bill bill);
	
	public Bill updateBill(Bill bill)throws BillException;
	
	public Bill removeBill(int billId)throws BillException;
	
	public Bill viewBill(int billId)throws BillException;
	
	public List<Bill> viewBillsByDates(LocalDate startDate, LocalDate endDate)throws BillException;
	
	public List<Bill> viewBillsByCustomerId(String custId)throws BillException;
	
	public Double calculateTotalCost(Bill bill)throws BillException;

}
