//package com.vidhyaa.dao;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
////import org.hibernate.query.Query;
//
//import com.vidhyaa.model.Book;
//
//@Repository
//public class BookDaoImpl implements BookDAO {
//	
//	@Autowired
//	private SessionFactory sessionFactory;
//
//	@Override
//	public long save(Book book) {
//		sessionFactory.getCurrentSession().save(book);
//		return book.getId();
//	}
//
//	@Override
//	public Book get(long id) {
//		return sessionFactory.getCurrentSession().get(Book.class, id);
//	}
//
//	@Override
//	public List<Book> list() {
//		List<Book> list = sessionFactory.getCurrentSession().createQuery("from Book").list();
//		return list;
//		
//	}
//
//	@Override
//	public void update(long id, Book book) {
//		
//		Session session = sessionFactory.getCurrentSession();
//		Book oldBook = session.byId(Book.class).load(id);
//		oldBook.setAuthor(book.getAuthor());
//		oldBook.setTitle(book.getTitle());
//		session.flush();
//		
//		
//		
//		
//	}
//
//	@Override
//	public void delete(long id) {
//		
//		
//		Session session = sessionFactory.getCurrentSession();
//		Book book = session.byId(Book.class).load(id);
//		session.delete(book);
//		
//		
//		
//	}
//
//
//	@Override
//	public List<Book> search(String keyword) {
//	Session session = sessionFactory.getCurrentSession();
//	org.hibernate.query.Query q = session.
//			createQuery("From Book b where b.title like concat('%',:title,'%') or b.author like concat('%',:title,'%')");
//	q.setParameter("title", keyword);
//	List<Book> list = q.list();
//		System.out.println(list);
//		return list;
//		
//	}
//
//	
//}
