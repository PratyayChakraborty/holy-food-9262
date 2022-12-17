package com.foodu.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String fullName;
	private Integer age;
	private String gender;
	private String mobileNumber;
	private String email;
	private String password;
	

	@JsonIgnore
	@OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
	private Set<Address> addresses = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<OrderDetails> orders = new ArrayList<>();
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private FoodCart foodCart;



	public Customer(Integer customerId, String fullName, Integer age, String gender, String mobileNumber, String email,
			String password) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
//		this.foodCart = foodCart;
	}

	

	public Integer getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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



	public Set<Address> getAddresses() {
		return addresses;
	}



	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}



	public List<OrderDetails> getOrders() {
		return orders;
	}



	public void setOrders(List<OrderDetails> orders) {
		this.orders = orders;
	}



//	public FoodCart getFoodCart() {
//		return foodCart;
//	}
//
//
//
//	public void setFoodCart(FoodCart foodCart) {
//		this.foodCart = foodCart;
//	}



	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fullName=" + fullName + ", age=" + age + ", gender=" + gender
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", password=" + password + ", addresses="
				+ addresses +  "]";
	}
	
	
	
}
