package com.mydreamstore.todolist;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mydreamstore.todolist.dao.TaskDAO;
import com.mydreamstore.todolist.model.Task;

public class TaskTest {
	
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.mydreamstore");
		context.refresh();
		TaskDAO taskDAO = (TaskDAO) context.getBean("taskDAO");
		Task task = (Task) context.getBean("task");
		
		// Create Operation
		//task.setTask_id("TK1");
		task.setTask_title("Deposite cash in bank");
		task.setDescription("To take 10000 rs from home and deposit at Andhra bank. A/C details XXXX IFSC : XXXXX");
		
	    taskDAO.saveOrUpdate(task);
		
	    
	    
			System.out.println("Task exist");
		
	}

}
