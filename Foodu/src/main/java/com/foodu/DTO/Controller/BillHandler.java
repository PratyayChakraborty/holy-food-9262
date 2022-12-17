package com.foodu.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodu.Model.Bill;
import com.foodu.Service.BillServiceDao;



@RestController
public class BillHandler {
   
	@Autowired
	private BillServiceDao bService;
	
	
	//add bill handler
	 @PostMapping("/bills")
	public ResponseEntity<Bill> addBillHandler(@RequestBody Bill bill){ 
		
		 Bill addedbill = bService.addBill(bill);
		 return new ResponseEntity<Bill>(addedbill,HttpStatus.CREATED);
	}
	 
	// view  bill handler
	  @GetMapping("/bills/{id}")
	 public ResponseEntity<Bill> viewBillHandler(@PathVariable("id") Integer billId){ 
		 Bill bill = bService.viewBill(billId);
		 return new ResponseEntity<Bill>(bill,HttpStatus.OK);
	 }
	 
	 //
	 @PutMapping("/bills")
	 public ResponseEntity<Bill>updateBillHandler(@RequestBody Bill  bill){ 
		 Bill updatedbill = bService.updateBill(bill);
		 return new ResponseEntity<Bill>(bill,HttpStatus.ACCEPTED);
	 } 
	 
	  
	 @DeleteMapping("/dbills")
	 public ResponseEntity<Bill>  removeBillHandler( @RequestParam Integer billId){ 
//		 System.out.println(billId);
		 Bill deletedbill = bService.removeBill(billId);
//		 System.out.println(deletedbill);
		 return new ResponseEntity<Bill>(deletedbill, HttpStatus.OK);
	 }
	 
	 @GetMapping("/allbills")
	 public ResponseEntity<List<Bill>> viewBillsByDatesHandler(@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate){ 
		  List<Bill> bills = bService.viewBillsByDates(startDate, endDate);
		  return new ResponseEntity<List<Bill>>(bills,HttpStatus.OK);
	 }
	 
	 
	 
	 
	 
}