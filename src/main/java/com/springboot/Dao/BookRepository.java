package com.springboot.Dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entities.Book;
@Repository
public interface BookRepository extends CrudRepository<Book,Integer> {
    public void getBookDetails();
	
	
}
