package com.mydreamstore.todolist.dao;

import java.util.List;

import com.mydreamstore.todolist.model.User;

public interface UserDAO {
	
	public List<User> list();
	public User get(String mailid);
	public void saveOrUpdate(User user);
	public void delete(String mailid); 
	public boolean isValidUser(String mailid, String password);

}
