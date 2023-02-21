package com.sunil.BookMicroservice.Entity;

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
@Table(name="status_list")
public class Details {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;
    
    private Integer book_Id;
    private Integer user_Id;
	private String date;
	private String status;
	
	
	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Details(Integer id, Integer book_Id, Integer user_Id, String date, String status) {
		super();
		Id = id;
		this.book_Id = book_Id;
		this.user_Id = user_Id;
		this.date = date;
		this.status = status;
	}

	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Integer getBook_Id() {
		return book_Id;
	}
	public void setBook_Id(Integer book_Id) {
		this.book_Id = book_Id;
	}
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Override
	public String toString() {
		return "Details [Id=" + Id + ", book_Id=" + book_Id + ", user_Id=" + user_Id + ", date=" + date + ", status="
				+ status + "]";
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
}