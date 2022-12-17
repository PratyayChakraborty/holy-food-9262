package com.foodu.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private LocalDateTime orderDate;
	private Boolean orderStatus;
	
	@OneToOne
//	@JsonIgnore
	private Address orderAddress;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Customer customer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Restaurant restaurant;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "od")
	@JsonIgnore
	private List<OrderItems> itemList = new ArrayList<>();
	
	@OneToOne
	@JsonIgnore
	private  Bill bill;
	
     public OrderDetails() {
		
	}

	public OrderDetails(Integer orderId, LocalDateTime orderDate, Boolean orderStatus, Address orderAddress,
			Customer customer, Restaurant restaurant, List<OrderItems> itemList, Bill bill) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.orderAddress = orderAddress;
		this.customer = customer;
		this.restaurant = restaurant;
		this.itemList = itemList;
		this.bill = bill;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public Boolean getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Address getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(Address orderAddress) {
		this.orderAddress = orderAddress;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<OrderItems> getItemList() {
		return itemList;
	}

	public void setItemList(List<OrderItems> itemList) {
		this.itemList = itemList;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", orderAddress=" + orderAddress + ", customer=" + customer + ", restaurant=" + restaurant
				+ ", itemList=" + itemList + ", bill=" + bill + "]";
	}

	

	
	
	
}
