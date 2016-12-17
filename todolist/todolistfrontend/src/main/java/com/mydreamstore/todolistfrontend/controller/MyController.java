package com.mydreamstore.todolistfrontend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mydreamstore.todolist.dao.TaskDAO;
import com.mydreamstore.todolist.dao.UserDAO;
import com.mydreamstore.todolist.model.Task;
import com.mydreamstore.todolist.model.User;

@Controller
public class MyController {
	
	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO; 
	
	@Autowired
	Task task; 
	
	@Autowired
	TaskDAO taskDAO;
	
	
	@RequestMapping("/")
	public ModelAndView myfunction(HttpSession session)
	{
	  ModelAndView mv=new ModelAndView("/home");
	  return mv;
		
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("isUserClickedLoginHere", "true");
		return mv;
	}
	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("/register");
		mv.addObject("user", user);
		mv.addObject("isUserClickedRegisterHere", "true");
		return mv;
	}	
	
	@RequestMapping(value = "here/register", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("User") User user) {
	    userDAO.saveOrUpdate(user);
		ModelAndView mv = new ModelAndView("/home");
		mv.addObject("successMessage", "You are successfully register");

		return mv;
	}

}
