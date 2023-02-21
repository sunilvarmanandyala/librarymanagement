package com.sunil.BookMicroservice.Controller;


import java.security.PublicKey;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sunil.BookMicroservice.Entity.Book;
import com.sunil.BookMicroservice.ServiceImpl.BookServiceImpl;



@RestController
@CrossOrigin
public class BookController {
	private RestTemplate restTemp;
    @Autowired
    public BookController(RestTemplateBuilder builder) {
        this.restTemp = builder.build();
    }
    
	@Autowired
	private BookServiceImpl bookService;
	@GetMapping("/Getbook") // Get book Details
	public List<Book> fetchBookList()
	{
		return bookService.fetchBookList();
	}
	@PostMapping("/Addbook") //Add Book
	public Book addBook(@RequestBody Book book) throws Exception
	{
		return bookService.addstaff(book);
	}
	@GetMapping("/addbook/{accessnumber}/{title}/{author}/{subject}/{keyword}/{category}") //Create Books
	public Book saveBook(@PathVariable("accessnumber") String accessnumber,@PathVariable("title") String title,@PathVariable("author") String author,@PathVariable("subject") String subject,@PathVariable("keyword") String keyword,@PathVariable("category") String category) throws Exception
	{
		Book book = new Book();
		book.setAccessnumber(accessnumber);
		book.setTitle(title);
		book.setAuthor(author);
		book.setSubject(subject);
		book.setKeyword(keyword);
		book.setCategory(category);
		return bookService.saveBook(book);
	}
	@GetMapping("/book/{id}") //Get book Details by book Id
	public Book fetchBookById(@PathVariable("id") Integer book_Id)
	{
		return bookService.fetchBookById(book_Id);
	}
	@GetMapping("/book/access/{accessnumber}") //Get book Details by book Id
	public Book fetchBookByaccessnumber(@PathVariable String accessnumber)
	{
		return bookService.fetchBookByaccessnumber(accessnumber);
	}
	@DeleteMapping("/book/{book_Id}") //Delete book Details by book id
	public String deleteDoctorById(@PathVariable("book_Id") Integer book_Id)
	{
		bookService.deleteBookById(book_Id);
		return "Book Deleted Successfully";
	}
	@PutMapping("/book/{id}") //update book Details by book id
	public Book updateBook(@PathVariable("id") Integer book_Id,@RequestBody Book book)
	{
		return bookService.updateBook(book_Id,book);
	}
	@GetMapping("/book/title/{title}") //Get book details by book title
	public List<Book> fetchBytitle(@PathVariable("title") String title)
	{
		return bookService.fetchBytitle(title);
	}
	@GetMapping("/book/author/{author}") //Get book details by book title
	public List<Book> fetchBookByauthor(@PathVariable("author") String author)
	{
		return bookService.fetchBookByauthor(author);
	}
	@GetMapping("/book/subject/{subject}") //Get book details by book title
	public List<Book> fetchBookBysubject(@PathVariable("subject") String subject)
	{
		return bookService.fetchBookBysubject(subject);
	}
	@GetMapping("/book/keyword/{keyword}") //Get book details by book title
	public List<Book> fetchBookBykeyword(@PathVariable("keyword") String keyword)
	{
		return bookService.fetchBookBykeyword(keyword);
	}
	@GetMapping("/book/category/{category}") //Get book details by book title
	public List<Book> fetchBookBycategory(@PathVariable("category") String category)
	{
		return bookService.fetchBookBycategory(category);
	}
	@GetMapping("/books")
		public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}

	@ExceptionHandler(ConstraintViolationException.class)
	  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	  ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
	    return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	  }
}