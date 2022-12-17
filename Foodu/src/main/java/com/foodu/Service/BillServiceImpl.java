package com.foodu.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodu.Exception.BillException;
import com.foodu.Model.Bill;
import com.foodu.Repository.BillRepository;
@Service
public class BillServiceImpl implements BillServiceDao{
  
	@Autowired
	 private  BillRepository bDao ;
	
	@Override
	public Bill addBill(Bill bill) {
		// TODO Auto-generated method stub 
		  Bill newbill = bDao.save(bill);
		return newbill;
	}

	@Override
	public Bill updateBill(Bill bill) throws BillException {
		// TODO Auto-generated method stub
		 Optional<Bill> opt = bDao.findById(bill.getBillId());
		 
		 if(opt.isPresent()) {
			 Bill  updatedbill = bDao.save(bill);
			
			 return updatedbill;
		   
		 }else { 
			 throw new BillException("Invalid Bill details.");
		 }
		 
	}

	@Override
	public Bill removeBill(int billId) throws BillException {
		// TODO Auto-generated method stub 
		Optional<Bill> opt = bDao.findById(billId);
		 if(opt.isPresent()) { 
			 Bill existingBill = opt.get();
			 bDao.delete(existingBill);
			 return existingBill;
			 
		 }else { 
			 throw new BillException("Bill does not exist with billId: "+ billId);
		 }
		
		
	}

	@Override
	public Bill viewBill(int billId) throws BillException {
		// TODO Auto-generated method stub 
		Optional<Bill> opt = bDao.findById(billId);
		 if(opt.isPresent()) { 
			 Bill existingBill = opt.get();
			
			 return existingBill;
			 
		 }else { 
			 throw new BillException("Bill does not exist with billId: "+ billId);
		 }
		
	}

	@Override
	public List<Bill> viewBillsByDates(LocalDate startDate, LocalDate endDate) throws BillException {
		// TODO Auto-generated method stub 
		List<Bill> bills = bDao.viewBillsByDates(startDate,endDate);
		 if(bills.isEmpty()) { 
			 throw new BillException("Bills not found between date: "+ startDate +""+ endDate);
		 }
		return bills;
	}

	@Override
	public List<Bill> viewBillsByCustomerId(String custId) throws BillException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calculateTotalCost(int billId) throws BillException {
		// TODO Auto-generated method stub 
		Optional<Bill> opt = bDao.findById(billId);
		 if(opt.isPresent()) { 
			 Bill existingBill = opt.get();
			 Double totalamount = existingBill.getTotalCost();
			 return totalamount;
			 
		 }else { 
			 throw new BillException("invalid bill details.");
		 }

	}

	

}
