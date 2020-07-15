package com.vidhyaa.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.vidhyaa.model.Book;
import com.vidhyaa.service.BookService;


@Controller
public class HelloController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/demo")
	public ModelAndView demo() {
		
		ModelAndView model = new ModelAndView("index");
		model.addObject("msg", "Hello world" );
		System.out.println("bdjahsd");

		return model;
		
	}
	
	@RequestMapping(value = "/api/book", method = RequestMethod.GET )
	public ModelAndView getDetails() {
		
		ModelAndView model = new ModelAndView("bookdetails");
		List<Book> list = bookService.findAll();
		//model.addObject("headerMessage", "Welcome to Central Library" );
		model.addObject("booklist", list);
		return model;
		
	}
	
//	@RequestMapping(value = "/new", method = RequestMethod.POST)
//	public ModelAndView submit(@ModelAttribute("book") Book book, BindingResult result) {
//		
//		
//		if (result.hasErrors()) {
//			
//			ModelAndView model = new ModelAndView("admission");
//			return model;
//			
//		}
//		
//		ModelAndView model = new ModelAndView("newSearch");
//		model.addObject("message", "Submission is success");
//		return model;
//		
//	}
	
	
	@RequestMapping("/new")
	public String newCustomerForm(Map<String, Object> model) {
    Book book = new Book();
	    model.put("bookDetails", book);
	    return "new_book";
	}
//	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Book book) {
		bookService.save(book);
		return "redirect:/api/book";
	}
//	
	@RequestMapping("/delete")
	public String deleteBook(@RequestParam long id) {
	    bookService.delete(id);
	    return "redirect:/api/book";       
	}
//	
	@RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam long id ) {
	    ModelAndView mav = new ModelAndView("edit_customer");
	    Book book = bookService.get(id);
	    mav.addObject("editBook", book);
 
    return mav;
	}
//	
//	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
	    List<Book> result = bookService.search(keyword);
	    ModelAndView mav = new ModelAndView("search");
	    mav.addObject("result", result);
	 
	    return mav;    
}
	
//	@RequestMapping(value = "/submit", method = RequestMethod.POST)
//	public ModelAndView submit(@RequestParam("empName") String name) {
//		
//		ModelAndView model = new ModelAndView("submit");
//		model.addObject("msg", "Hi " + name + ", Succesfully submited");
//		return model;
//		
//	}
	



}



