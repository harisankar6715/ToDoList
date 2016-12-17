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
public class UserController { 
	
	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO; 
	
	@Autowired
	Task task; 
	
	@Autowired
	TaskDAO taskDAO; 
	
	@RequestMapping("/login")
	public ModelAndView isValidUser(@RequestParam(value = "name") String mailid,
			@RequestParam(value = "password") String password, HttpSession session) {

		ModelAndView mv = new ModelAndView("home");
		boolean isValidUser = userDAO.isValidUser(mailid, password);
		if (isValidUser == true) {

			user = userDAO.get(mailid);
			session.setAttribute("loggedInUser", user.getMailid());
			session.setAttribute("user", user);
			System.out.println(user.getName() + "logged in");
			
		} else {

			mv.addObject("invalidCredentials", "true");
			mv.addObject("errorMessage", "Invalid Credentials");

		}

		return mv;
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("home");
		session.invalidate();
		session = request.getSession(true);
		
		mv.addObject("logoutMessage", "You successfully logged out");
		mv.addObject("loggedOut", "true");
	
		return mv;
	 }
	
	@RequestMapping("/newTask")
	public ModelAndView news() {

		ModelAndView mv = new ModelAndView("/task");
		mv.addObject("isnewTask", "true");
		return mv;
	}
	
	@RequestMapping("/pendingTask")
	public ModelAndView pending() {

		ModelAndView mv = new ModelAndView("/task");
		mv.addObject("ispendingTask", "true");
		return mv;
	}
	
	@RequestMapping("/completedTask")
	public ModelAndView completed() {

		ModelAndView mv = new ModelAndView("/task");
		mv.addObject("iscompletedTask", "true");
		return mv;
	}
	
	
	
	@RequestMapping(value = "/newTask", method = RequestMethod.GET)
	public String List(Model model) {
		
		model.addAttribute("task", task);
		model.addAttribute("taskList", this.taskDAO.list());
		return "task";
	}
	
	
	
	
	@RequestMapping(value = "/to_add_newTask", method = RequestMethod.POST)
	public String addTasks(@ModelAttribute("task") Task task)
	{
		
		taskDAO.saveOrUpdate(task);

		return "redirect:/new";
	}

}
