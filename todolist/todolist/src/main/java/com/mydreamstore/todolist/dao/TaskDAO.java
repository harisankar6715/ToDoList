package com.mydreamstore.todolist.dao;

import java.util.List;

import com.mydreamstore.todolist.model.Task;

public interface TaskDAO { 
	
	public List<Task> list();
	public Task getTask(int task_id);
	public void saveOrUpdate(Task task);
	public void delete(int task_id);

}
