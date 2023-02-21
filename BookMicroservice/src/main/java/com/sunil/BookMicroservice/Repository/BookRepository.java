package com.sunil.BookMicroservice.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunil.BookMicroservice.Entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	public List<Book> findBytitleStartsWith(String title);
	public Book findBytitleEqualsIgnoreCase(String title);
	public Book findByAccessnumber(String accessnumber);
	public List<Book> findByAuthor(String author);
	public List<Book> findBySubjectStartsWith(String subject);
	public List<Book> findByKeyword(String keyword);
	public List<Book> findByCategory(String category);
//	public List<Book> deleteBookById(Integer bookId);
//	public List<Book> searchBooks(String Book);
}