package com.ksv.minglex.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.ksv.minglex.model.User;

@Service("sessionService")
public class SessionService {
	public User getCurrentUser(HttpServletRequest request) {
		User user = null;
		try {
			user = (User) request.getSession().getAttribute("user");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public void setCurrentUser(HttpServletRequest request, User user) {
		request.getSession().setAttribute("user", user);
	}

	public void removeCurrentSession(HttpServletRequest request) {
		request.getSession().invalidate();
	}
}
