package com.sunil.BookMicroservice.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.BookMicroservice.Entity.Book;
import com.sunil.BookMicroservice.Repository.BookRepository;
import com.sunil.BookMicroservice.Service.BookService;


@Service
public class BookServiceImpl 
{
	@Autowired
	public BookRepository bookRepository;
	public Book saveBook(Book book) throws Exception
	{
		String accessnumber = book.getAccessnumber();
	    Book existingBook = bookRepository.findByAccessnumber(accessnumber);
		
		if (existingBook == null) {
			return bookRepository.save(book);
		}
		else {
			throw new Exception("Book data already exists");
		}
		
	}
//	public List<Book> searchBooks(String query){
//	List<Book> books=bookRepository.searchBooks(query)	;
//	return books;
//	}
	public List<Book> fetchBookList()
	{
		return bookRepository.findAll();
	}
	public Book fetchBookById(Integer bookId)
	{
		return bookRepository.findById(bookId).get();
	}
	public void deleteBookById(Integer bookId)
	{
		bookRepository.deleteById(bookId);
	}
	public Book updateBook(Integer bookId,Book book)
	{
		Book bDB = bookRepository.findById(bookId).get();
		if(Objects.nonNull(book.getAccessnumber())&&
				!"".equalsIgnoreCase(book.getAccessnumber()))
		{
			bDB.setAccessnumber(book.getAccessnumber());
		}
		if(Objects.nonNull(book.getTitle())&&
				!"".equalsIgnoreCase(book.getTitle()))
		{
			bDB.setTitle(book.getTitle());
		}
		if(Objects.nonNull(book.getAuthor())&&
				!"".equalsIgnoreCase(book.getAuthor()))
		{
			bDB.setAuthor(book.getAuthor());
		}
		if(Objects.nonNull(book.getSubject())&&
				!"".equalsIgnoreCase(book.getSubject()))
		{
			bDB.setSubject(book.getSubject());
		}
		if(Objects.nonNull(book.getKeyword())&&
				!"".equalsIgnoreCase(book.getKeyword()))
		{
			bDB.setKeyword(book.getKeyword());
		}
		if(Objects.nonNull(book.getCategory())&&
				!"".equalsIgnoreCase(book.getCategory()))
		{
			bDB.setCategory(book.getCategory());
		}
		return bookRepository.save(bDB);
	}
	public List<Book> fetchBytitle(String title)
	{
		return bookRepository.findBytitleStartsWith(title);
	}
	public Book fetchBookByaccessnumber(String accessnumber) {
		
		return bookRepository.findByAccessnumber(accessnumber);
	}
	public List<Book> fetchBookByauthor(String author)
	{
		return bookRepository.findByAuthor(author);
	}
	public List<Book> fetchBookBysubject(String subject)
	{
		return bookRepository.findBySubjectStartsWith(subject);
	}
	public List<Book> fetchBookBykeyword(String keyword)
	{
		return bookRepository.findByKeyword(keyword);
	}
	public List<Book> fetchBookBycategory(String category)
	{
		return bookRepository.findByCategory(category);
	}
	public Book addstaff(Book book) {
		return bookRepository.save(book);
	}
	public List<Book> getAllBooks() {
		List<Book> book=new ArrayList<>();
	    bookRepository.findAll().forEach(book::add);
	    return book;
	}
	
	
}