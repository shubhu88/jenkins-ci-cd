package com.irctc_backend.hash;

import java.util.Date;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Id;

@RedisHash("Customer")
public class Customer {

	@Id
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date dob;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
