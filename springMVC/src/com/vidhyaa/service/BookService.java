package com.vidhyaa.service;

import java.util.List;
import java.util.Optional;

import com.vidhyaa.model.Book;

public interface BookService {
	
	List<Book> findAll();
	
	public void delete(long id);
	
	public void save(Book book);
	
	Book get(long id);
	
	
//	//save the record
//		long save(Book book);
//		
//		
//		//get a single record 
//		Book get(long id);
//		
//		//get all record 
//		List<Book> list();
//		
//		//Update the record
//		void update(long id, Book book);
////		
//		//Delete the record 
//		void delete(long id);
//		
//		Search the keyword
		List<Book> search(String keyword);

}
