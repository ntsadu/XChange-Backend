package com.xchange.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@Table(name="user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // needed to avoid org.springframework.http.converter.HttpMessageNotWritableException
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="userID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;

	@Column(name="firstname")
	private String firstname;

	@Column(name="lastname")
	private String lastname;

	@Column(name="email", nullable=false, unique=true)
	private String email;

	@Column(name="username", nullable=false, unique=true)
	private String username;

	@Column(name="password")
	private String password;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userID) {
		this.userId = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password="
				+ password + ", firstName=" + firstname + ", lastName=" + lastname + ", email=" + email + "]";
	}
	
}