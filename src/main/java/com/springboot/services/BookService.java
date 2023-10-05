package com.springboot.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springboot.entities.Book;
import com.springboot.Dao.BookRepository;

@Component
public class BookService  {
	@Autowired
	BookRepository bookRepository;
	// get all the books 
	public List<Book> getBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
		

	}
	
	//get one book service
	public Book getBookById(int id) {
		 Optional<Book> optional = this.bookRepository.findById(id);
		Book b = optional.stream().filter(e->e.getId() == id).findFirst().get();
		return b;
	}
	
	// add a book
	public Book addBook(Book book) {
		 Book b = bookRepository.save(book);		
		return b;	
		
	}

}
