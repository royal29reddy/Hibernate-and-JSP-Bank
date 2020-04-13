package org.kautilya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="users")
@Table(name="users")
public class Users {
	@Id
	@Column(name="account_number")
	long account_number;
	@Column(name="first_name")
	String firstName;
	@Column(name="last_name")
	String lastName;
	@Column(name="user_name")
	String userName;
	@Column(name="password")
	String password;
	@Column(name="email")
	String email;
	@Column(name="mobile_number")
	long mobile;
	
	public Users() {
	}

	public Users(long account_number, String firstName, String lastName, String userName, String password, String email,
			long mobile) {
		this.account_number = account_number;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}



	public Users(String firstName, String lastName, String userName, String password, String email,long mobile) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobile=mobile;
	}



	public long getaccount_number() {
		return account_number;
	}

	public void setaccount_number(int account_number) {
		this.account_number = account_number;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Users [account_number=" + account_number + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", email=" + email + ", mobile=" + mobile + "]";
	}

	
	
	

}
