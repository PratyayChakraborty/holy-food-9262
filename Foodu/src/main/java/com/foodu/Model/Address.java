package com.foodu.Model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	
}
