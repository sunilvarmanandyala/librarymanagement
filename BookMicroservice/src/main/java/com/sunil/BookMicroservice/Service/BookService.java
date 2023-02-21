package com.sunil.BookMicroservice.Service;


import java.util.List;

import com.sunil.BookMicroservice.Entity.Book;


public interface BookService {
	public Book saveBook(Book book);
	public List<Book> fetchBooklist();
	public Book fetchBookById(Integer bookId);
	public void deleteBookById(Integer bookId);
	public Book updateBook(Integer bookId,Book book);
	public Book fetchBytitle(String title);
	public Book fetchBookByaccessnumber( String accessnumber);
	List<Book> findBytitle(String title);
}