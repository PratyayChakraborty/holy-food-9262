package com.foodu.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer restaurantId;
	private String restaurantName;
	private String managerName;
	private String contactNumber;
	private String email;
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
	@JsonIgnore
	private List<Item> itemList = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
	@JsonIgnore
	private List<OrderDetails> orderLists = new ArrayList<>();
	
	@ManyToMany(targetEntity = Customer.class, cascade = CascadeType.ALL) 
	@JsonIgnore
	private Set<Customer> customers = new HashSet<>();

	@OneToMany(targetEntity = Category.class, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Category> categories = new HashSet<>();
	
	
	

	public Restaurant() {
	
	}

	public Restaurant(Integer restaurantId, String restaurantName, String managerName, String contactNumber,
			String email, String password, Address address, List<Item> itemList, List<OrderDetails> orderLists,
			Set<Customer> customers, Set<Category> categories) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.managerName = managerName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
		this.address = address;
		this.itemList = itemList;
		this.orderLists = orderLists;
		this.customers = customers;
		this.categories = categories;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public List<OrderDetails> getOrderLists() {
		return orderLists;
	}

	public void setOrderLists(List<OrderDetails> orderLists) {
		this.orderLists = orderLists;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", managerName="
				+ managerName + ", contactNumber=" + contactNumber + ", email=" + email + ", password=" + password
				+ ", address=" + address + ", itemList=" + itemList + ", orderLists=" + orderLists + ", customers="
				+ customers + ", categories=" + categories + "]";
	}
	
	
	
	
}
