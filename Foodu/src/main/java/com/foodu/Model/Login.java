package com.foodu.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Login {
	@Id
	private Integer customerId;
	private String fullName;
	private String password;
}
