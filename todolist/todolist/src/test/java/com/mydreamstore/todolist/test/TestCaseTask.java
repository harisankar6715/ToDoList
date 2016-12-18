package com.mydreamstore.todolist.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mydreamstore.todolist.dao.TaskDAO;
import com.mydreamstore.todolist.model.Task;


public class TestCaseTask { 
	
	@Autowired
	static TaskDAO taskDAO;
	@Autowired
	static Task task;
	static AnnotationConfigApplicationContext context;
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mydreamstore");
		context.refresh();
		taskDAO = (TaskDAO) context.getBean("taskDAO");
		task = (Task) context.getBean("task");
	}
	@Test
	public void taskNameTest() {
		task = taskDAO.getTask(65);
		String name = task.getTask_title();
		System.out.println("******************----"+name);
		assertEquals("Task Name Test", "Deposite cash in bank", name);
	}
}