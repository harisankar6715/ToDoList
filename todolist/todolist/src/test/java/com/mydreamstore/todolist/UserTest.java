package com.mydreamstore.todolist;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mydreamstore.todolist.dao.UserDAO;
import com.mydreamstore.todolist.model.User;

public class UserTest {
	
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.mydreamstore");
		context.refresh();
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		User user = (User) context.getBean("user");
		
		// Create Operation
		user.setName("HARI");
		user.setPassword("hari");
		user.setMailid("harisankar6715@gmail.com");
		
	  
		
	    userDAO.saveOrUpdate(user);
		
	    if(userDAO.get("harisankar6715@gmail.com")== null)
		{
			System.out.println("User does not exist");
		}
		else
		{
			System.out.println("User exists..");
			System.out.println();
		} 

	}

}
