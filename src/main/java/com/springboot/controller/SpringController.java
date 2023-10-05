package com.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entities.Book;
import com.springboot.services.BookService;

@RestController
public class SpringController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity< List<Book> > getBooks()
	{
		 List<Book> book = this.bookService.getBooks();
		 if(book != null)
		 return ResponseEntity.status(HttpStatus.OK).build();
		 
		 return ResponseEntity.of(Optional.of(book));
		 
		
	}
	@GetMapping("/book/{id}")
	public ResponseEntity<Object> getBookById(@PathVariable int id)
	{
		
		Book b = this.bookService.getBookById(id);
		if(b == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.of(Optional.of(b));
	}
	
	@PostMapping("/book")
	public ResponseEntity<Book> addBook (@RequestBody Book book)
	{
	
		 Book b = this.bookService.addBook(book);
		 if( b == null)
			 return ResponseEntity.status(HttpStatus.CREATED).build();
		 return ResponseEntity.of(Optional.of(b));
		
	}

}
