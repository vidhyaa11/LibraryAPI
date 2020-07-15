package com.vidhyaa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.Param;

import com.vidhyaa.model.Book;



public interface BookDAO extends JpaRepository<Book, Long> {
	
	//
    List<Book> findAll();
    
    @Query(value = "Select * from Book b where b.title LIKE concat('%',:keyword,'%')"
    		+ "OR b.author LIKE concat('%',:keyword,'%')", nativeQuery = true)
    public List<Book> search( @Param("keyword") String keyword);
    
    
//   @Modifying
//    @Query("Update Book b set b.author = ?2, b.title = ?3 where b.id = :id")
//    public void update(@Param("id") long id, Book book);

	
//	//save the record
//	long save(Book book);
//	
//	
//	//get a single record 
//	Book get(long id);
//	
//	//get all record 
//	List<Book> list();
//	
//	//Update the record
//	void update(long id, Book book);
//	
//	//Delete the record 
//	void delete(long id);
//	
//	//search the record
//	 List<Book> search(String keyword);
	
	

}
