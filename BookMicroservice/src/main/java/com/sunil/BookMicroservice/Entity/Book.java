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


@SuppressWarnings("unused")
@Entity
@Table(name="Booklist")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int book_Id;
	private String img;
	private String accessnumber;
    @NotBlank(message = "access number should not be empty")
	private String title;
	private String author;
	private String subject;
	@NotNull(message = " keyword should not be empty")
	private String keyword;
	private String category;
	
//	@JsonManagedReference
	@ManyToMany
	private List<Staff> staffs = new ArrayList<Staff>();
	@ManyToMany
	private List<Details> details = new ArrayList<Details>();

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Book(int book_id, String img, String accessnumber, @NotBlank(message = "access number should not be empty") String title,
			String author, String subject, @NotNull(message = "doctor keyword should not be empty") String keyword,
			String category) {
		super();
		book_Id = book_id;
		this.img = img;
		this.accessnumber = accessnumber;
		this.title = title;
		this.author = author;
		this.subject = subject;
		this.keyword = keyword;
		this.category = category;
	}
 	public int getBook_Id() {
		return book_Id;
	}
	public void setBook_Id(int id) {
		book_Id = id;
	}
	
	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public String getAccessnumber() {
		return accessnumber;
	}
	public void setAccessnumber(String accessnumber) {
		this.accessnumber = accessnumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
//	public Book get() {
//		// TODO Auto-generated method stub
//		return null;
//	}



	public boolean addBook() {
		// TODO Auto-generated method stub
		return false;
	}
	}