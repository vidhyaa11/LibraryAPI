package com.vidhyaa.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vidhyaa.dao.BookDAO;
import com.vidhyaa.model.Book;
import com.vidhyaa.service.BookService;

@CrossOrigin("*")
@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	@Autowired
	private BookDAO bookDAO;
	
	//Get All books
	@GetMapping("/book")
	public ResponseEntity<List<Book>> list(){
		
		
		List<Book> list = bookService.findAll();
		return ResponseEntity.ok().body(list);
		
		
	}
	
//	//save data
	@PostMapping("/book")
	public ResponseEntity<?> save(@RequestBody Book book){
		bookService.save(book);
	return ResponseEntity.ok().body("Book created");
}
//	
//
//Get single data
	@GetMapping("/book/{id}")
	public Book getOne(@PathVariable("id") long id){
		return bookDAO.findById(id).get();
	
}
//	
//	
	//Update Data
	@PutMapping("/book/{id}")
	public  Book update(@PathVariable("id") long id,@RequestBody Book book){
		
		return bookDAO.findById(id).map(book1 -> {
			book1.setId(book.getId());
			book1.setAuthor(book.getAuthor());
			book1.setTitle(book.getTitle());
			return bookDAO.save(book1);
			
		}).orElseGet(()->{
			book.setId(id);
			return bookDAO.save(book);
		});
		
	}
//	
//	
//	//Delete the data
	@DeleteMapping("/book/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")long id){
		
	bookService.delete(id);
		return ResponseEntity.ok().body("Record has been removed");
	}
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
	
	
	
	
	
	
	
	

}
