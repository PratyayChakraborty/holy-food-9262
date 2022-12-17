package com.foodu.Model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer addressId;  
	
	@NonNull
	@NotBlank(message = "building Name/ number is Mandatory")
	private String building;
	
	@NonNull
	@NotBlank(message = "street name is Mandatory")
	private String street;
	
	@NonNull
	@NotBlank(message = "city name is Mandatory")
	private String city;
	
	@NonNull
	@NotBlank(message = "city name is Mandatory")
	private String state;
	
	@NonNull
	@NotBlank(message = "country name is Mandatory")
	private String country;
	
	@Size(min = 6, max = 6, message = "pincode must be 6 digit ")
	private String pincode;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(building, other.building) && Objects.equals(pincode, other.pincode)
				&& Objects.equals(street, other.street);
	}
	@Override
	public int hashCode() {
		return Objects.hash(building, pincode, street);
	}
	public Address(Integer addressId,
			@NonNull @NotBlank(message = "building Name/ number is Mandatory") String building,
			@NonNull @NotBlank(message = "street name is Mandatory") String street,
			@NonNull @NotBlank(message = "city name is Mandatory") String city,
			@NonNull @NotBlank(message = "city name is Mandatory") String state,
			@NonNull @NotBlank(message = "country name is Mandatory") String country,
			@Size(min = 6, max = 6, message = "pincode must be 6 digit ") String pincode) {
		super();
		this.addressId = addressId;
		this.building = building;
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}
	public Address() {
	
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", building=" + building + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", pincode=" + pincode + "]";
	}
	
	
}
