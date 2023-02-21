package com.sunil.UserMicroservice.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="userlist")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer user_Id;
    @NotBlank(message = "user name should not be empty")
	private String username;
//@NotBlank(message = "password should not be empty")
	private String password;
//	@Pattern(regexp="^//d{10}$",message="Incorrect Number Will be Entered")
	private String userPhNo;
	
//	@JsonManagedReference
//	@ManyToMany
//	private List<Staff> staffs = new ArrayList<Staff>();
	
	public User() {
		super();
	}
	
	
	public User(Integer user_Id, @NotBlank(message = "user name should not be empty") String username, String password,
			String userPhNo) {
		super();
		this.user_Id = user_Id;
		this.username = username;
		this.password = password;
		this.userPhNo = userPhNo;
	}
	
	public Integer getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserPhNo() {
		return userPhNo;
	}

	public void setUserPhNo(String userPhNo) {
		this.userPhNo = userPhNo;
	}

	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", username=" + username + ", password= "+ password +" ,userPhNo=" + userPhNo
				+ "]";
	}


	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	

}