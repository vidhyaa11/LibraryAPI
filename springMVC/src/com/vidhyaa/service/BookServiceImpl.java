package com.vidhyaa.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidhyaa.dao.BookDAO;
import com.vidhyaa.model.Book;


@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	
	@Autowired
	private BookDAO bookDAO;

	@Override
	public List<Book> findAll() {
		
		return bookDAO.findAll();
	}

	@Override
	public void delete(long id) {
		bookDAO.deleteById(id);
	}

	@Override
	public void save(Book book) {
		bookDAO.save(book);
		
	}

	@Override
	public List<Book> search(String keyword) {
		return bookDAO.search(keyword);
	}

	@Override
	public Book get(long id) {
		System.out.println(bookDAO.getOne(id));
		return bookDAO.findById(id).get();
	}

//	@Override
//	@Transactional
//	public long save(Book book) {
//		return bookDAO.save(book);
//	}
//
//	@Override
//	@Transactional
//	public Book get(long id) {
//		// TODO Auto-generated method stub
//		return bookDAO.get(id);
//	}
//
//	@Override
//	@Transactional
//	public List<Book> list() {
//		return bookDAO.list();
//		
//	}
//
//	@Override
//	@Transactional
//	public void update(long id, Book book) {
//		bookDAO.update(id, book);
//		
//	}
//
//	@Override
//	@Transactional
//	public void delete(long id) {
//		bookDAO.delete(id);
//		
//	}
//
//	@Override
//	@Transactional
//	public List<Book> search(String keyword) {
//		// TODO Auto-generated method stub
//		return bookDAO.search(keyword);
//	}
//	
//	

}
