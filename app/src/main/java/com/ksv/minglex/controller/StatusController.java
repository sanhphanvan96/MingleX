package com.ksv.minglex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ksv.minglex.model.Status;
import com.ksv.minglex.model.User;
import com.ksv.minglex.service.StatusService;
import com.ksv.minglex.service.UserService;

@Controller
@RequestMapping(value = "/status")
public class StatusController {

	@Autowired
	private UserService userService;
	@Autowired
	private StatusService statusService;

	@RequestMapping(value = "/add-status", method = RequestMethod.POST)
	public ModelAndView addStatus(@Valid Status status, BindingResult bindingResult,
			HttpServletRequest httpServletRequest) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) httpServletRequest.getSession().getAttribute("user");
		if (user == null) {
			return new ModelAndView("redirect:/login");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("add-status");
		} else {
			status.setUser(user);
			modelAndView.addObject("successMessage", "Status has been created successfully");
			modelAndView.addObject("status", status);
			System.out.println(status.toString());
			statusService.save(status);
			return new ModelAndView("redirect:/explore");
		}
		return modelAndView;
	}
}
