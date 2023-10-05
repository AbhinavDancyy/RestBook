package com.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

import com.springboot.Dao.BookRepository;
import com.springboot.entities.Book;
@SpringBootApplication
@EntityScan("com.springboot.entities.Book")
public class RestBookApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(RestBookApplication.class, args);
		BookRepository bookRepository = applicationContext.getBean(BookRepository.class);
		Book book = new Book();
		book.setBookAuthor("Kiran Pattnaik");
		book.setBookName("Lets Connect Heart");
		
		Book book1 = new Book();
		book1.setBookAuthor("Kiran Pattnaik");
		book1.setBookName("Lets Connect Heart");
		
//		Book b = bookRepository.save(book);
		
		List<Book> list =new ArrayList<Book>();
		list.add(book);
		list.add(book1);		
		
		
		  Iterable<Book> itr  = bookRepository.saveAll(list);
		  itr.forEach(user -> { System.out.println(user); } );
		//System.out.println(b.toString());
		
	}

}
