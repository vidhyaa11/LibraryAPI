package com.vidhyaa.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/* This class is just to check the response for what client request
 * and response can be checked through appln to check REST/SOAP service
 * So we will not return any views
 */

@RestController
public class HelloRestController {
	
	@RequestMapping(value = "/students/{name}", method =RequestMethod.GET)
	public Student getStudentList(@PathVariable("name") String sName) {
		
		Student student = new Student();
		student.setStudentName(sName);
		
		return student;
	}
	
	@RequestMapping(value="/students/{name}", method = RequestMethod.PUT)
	public boolean updateList(@PathVariable("name") String sname, @RequestBody Student s1) {
		
		System.out.println("Old student name is : " +sname);
		System.out.println("New Student details are : " +s1.getStudentName() + ":" +s1.getCourse());
		
		return true;
	}
	
	@RequestMapping(value="/students", method = RequestMethod.POST)
	public ResponseEntity<Boolean> postList(@RequestBody Student s1) {
		
		System.out.println("New Student details are : " +s1.getStudentName() + ":" +s1.getCourse());
		
		return new ResponseEntity<Boolean>(true , HttpStatus.OK);
	}
	
	@RequestMapping(value="/students/{name}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteList(@PathVariable("name") String sname) {
		
		System.out.println("Student Name : " +sname);
		
		//delete the data from database
		
		return new ResponseEntity<Boolean>(true , HttpStatus.OK);
	}
	
	
}
