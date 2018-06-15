package com.ksv.minglex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ksv.minglex.model.User;
import com.ksv.minglex.service.UserService;


@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String index(Model model) {		
		return "index";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView loginView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView login(Model model, HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView();
		User curUser = new User();
		curUser.setUsername(httpServletRequest.getParameter("username"));
		curUser.setPassword(httpServletRequest.getParameter("password"));
		curUser.setGender(httpServletRequest.getParameter("gender"));
		String resMsg = userService.authenticateUser(curUser);
		if (resMsg.equals("SUCCESS")) {
			modelAndView.setViewName("index");
		} else {
			// has error
			System.out.println(resMsg);
			modelAndView.addObject("errorMessage", resMsg);
			modelAndView.setViewName("login");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		System.out.println("register ...................");
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByUsername(user.getUsername());
		if (userExists != null) {
			System.out.println("There is already a user registered with the username provide");
			bindingResult.rejectValue("username", "error.user", "There is already a user registered with the username provide");
		}
		if (bindingResult.hasErrors()) {
			System.out.println("Has error: " + bindingResult.getFieldError());
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("index");
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUsername(auth.getName());
		modelAndView.addObject("usernName", "Welcome " + user.getUsername());
		modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	
}
