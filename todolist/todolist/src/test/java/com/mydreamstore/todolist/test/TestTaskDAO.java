package com.mydreamstore.todolist.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mydreamstore.todolist.dao.TaskDAO;


public class TestTaskDAO { 
	
	@Autowired
	TaskDAO taskDAO;


	AnnotationConfigApplicationContext context;

	@Before
	public void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.mydreamstore");
		context.refresh();
		taskDAO = (TaskDAO) context.getBean("taskDAO");
	}

	@Test

	public void TaskTestCase() {
		int size = taskDAO.list().size();
		assertEquals("task list test case ", 1, size);

	}

}
