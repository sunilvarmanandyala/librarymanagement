package com.sunil.StaffMicroservice.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="stafflist")
public class Staff {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer staff_Id;
    @NotBlank(message = "user name should not be empty")
	private String username;
//@NotBlank(message = "password should not be empty")
	private String password;
//	@Pattern(regexp="^//d{10}$",message="Incorrect Number Will be Entered")
	private String staffPhNo;
	
	public Staff() {
		super();
	}
	
	public Staff(Integer staff_Id, @NotBlank(message = "user name should not be empty") String username,
			String password, String staffPhNo) {
		super();
		this.staff_Id = staff_Id;
		this.username = username;
		this.password = password;
		this.staffPhNo = staffPhNo;
	}


	

	public Integer getStaff_Id() {
		return staff_Id;
	}

	public void setStaff_Id(Integer staff_Id) {
		this.staff_Id = staff_Id;
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

	public String getStaffPhNo() {
		return staffPhNo;
	}

	public void setStaffPhNo(String staffPhNo) {
		this.staffPhNo = staffPhNo;
	}

	@Override
	public String toString() {
		return "User [staff_Id=" + staff_Id + ", username=" + username + ", password= "+ password +" ,staffPhNo=" + staffPhNo
				+ "]";
	}


	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	

}