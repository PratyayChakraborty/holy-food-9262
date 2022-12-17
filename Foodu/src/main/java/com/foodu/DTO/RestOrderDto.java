package com.foodu.DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.foodu.Model.Address;
import com.foodu.Model.Bill;
import com.foodu.Model.OrderItems;

import lombok.Data;

@Data
public class RestOrderDto {

	private Integer orderId;
	private LocalDateTime orderDate;
	private Boolean orderStatus;
	
	private Address orderAddress;
	
	private CustomerResDTO customer;
	
	private List<OrderItems> itemList = new ArrayList<>();
	
	private  Bill bill;
	
	
	
}
