package com.mydreamstore.todolist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="TASK")
@Component
public class Task {
		@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int task_id;
	private String task_title; 
	private String description;
	private String status; 
	private String user_mailid;
	@ManyToOne
	@JoinColumn(name="user_mailid" , nullable = false, updatable = false, insertable = false)
	private User user;
	public String getUser_mailid() {
		return user_mailid;
	}
	public void setUser_mailid(String user_mailid) {
		this.user_mailid = user_mailid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTask_id() {
		return task_id;
	}
	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}
	public String getTask_title() {
		return task_title;
	}
	public void setTask_title(String task_title) {
		this.task_title = task_title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
