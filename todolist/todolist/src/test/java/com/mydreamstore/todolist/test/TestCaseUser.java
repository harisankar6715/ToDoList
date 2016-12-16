package com.mydreamstore.todolist.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mydreamstore.todolist.dao.UserDAO;
import com.mydreamstore.todolist.model.User;

public class TestCaseUser {
	
	@Autowired
	static UserDAO userDAO;

	@Autowired
	static User user;

	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.mydreamstore");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
		user = (User) context.getBean("user");
	}

	@Test

	public void userNameTest() {
		user = userDAO.get("harisankar6715@gmail.com");
		String name = user.getMailid();
		assertEquals("User Name Test", "harisankar6715@gmail.com", name);

	}

}
