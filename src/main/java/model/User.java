package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
//    @GeneratedValue(generator="increment")
//	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name="userID")
	private int userId;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="email")
	private String email;

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
	
	public String toJSON() {
		return "{userId:" + userId + ", username:" + username + ", password:"
				+ password + ", firstName:" + firstname + ", lastName:" + lastname + ", email:" + email + "}";
	}
}
