package com.mydreamstore.todolist.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mydreamstore.todolist.dao.UserDAO;

public class TestUserDAO { 
	
	@Autowired
	UserDAO userDAO;


	AnnotationConfigApplicationContext context;

	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.mydreamstore");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}

	@Test

	public void UserTestCase() {
		int size = userDAO.list().size();
		assertEquals("user list test case ", 1, size);

	}

}
