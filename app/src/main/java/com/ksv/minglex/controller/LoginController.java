package com.ksv.minglex.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ksv.minglex.model.Status;
import com.ksv.minglex.model.User;
import com.ksv.minglex.service.StatusService;
import com.ksv.minglex.service.UserService;


@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private StatusService statusService;

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView loginView(HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		if (user != null) {
			return new ModelAndView("redirect:/profile");
		}
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
		
		//Validation
		if (curUser.getUsername() == null || curUser.getUsername().length() == 0) {
			modelAndView.addObject("errorMessage", "Username is required");
			modelAndView.setViewName("login");
			return modelAndView;
		}
		if (curUser.getPassword() == null || curUser.getPassword().length() == 0) {
			modelAndView.addObject("errorMessage", "Password is required");
			modelAndView.setViewName("login");
			return modelAndView;
		}
		
		//Authentication
		User resUser = userService.authenticateUser(curUser);
		if (resUser != null) {
			resUser.setPassword(null);
			httpServletRequest.getSession().setAttribute("user", resUser);
			return new ModelAndView("redirect:/profile");
		} else {
			// Has error
			modelAndView.addObject("errorMessage", "FAILED");
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
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByUsername(user.getUsername());
		if (userExists != null) {
			bindingResult.rejectValue("username", "error.user", "There is already a user registered with the username provide");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			return new ModelAndView("redirect:/login");
		}
		return modelAndView;
	}

	@RequestMapping(value="/profile", method = RequestMethod.GET)
	public ModelAndView profileView(Model model, HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView();
		
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		if (user == null) {
			return new ModelAndView("redirect:/login");
		}
		
		List<Status> statuses;
		String idStr = httpServletRequest.getParameter("id");
		if (idStr == null || idStr.length() == 0) {
			statuses = statusService.findByUser(Integer.toString(user.getId()));
		} else {
			statuses = statusService.findByUser(idStr);
		}
		Status status = new Status();
		modelAndView.addObject("status", status);
		modelAndView.addObject("curUser", user);
		modelAndView.addObject("statuses", statuses);
		modelAndView.setViewName("profile");
		return modelAndView;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logout(Model model, HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView();
		
		httpServletRequest.getSession().invalidate();
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping(value="/explore", method = RequestMethod.GET)
	public ModelAndView explore	(Model model, HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView();
		
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		if (user == null) {
			return new ModelAndView("redirect:/login");
		}
		List<Status> statuses = statusService.findAll();
		
		Status status = new Status();
		modelAndView.addObject("status", status);		
		modelAndView.addObject("curUser", user);
		modelAndView.addObject("statuses", statuses);
		modelAndView.setViewName("explore");
		return modelAndView;
	}
}
