package com.ksv.minglex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ksv.minglex.model.User;
import com.ksv.minglex.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public String authenticateUser(User user) {
		if (user.getUsername() == null || user.getUsername().length() == 0) {
			return "Username is required";
		}
		if (user.getPassword() == null || user.getPassword().length() == 0) {
			return "Password is required";
		}
		User userdb = userRepository.findByUsername(user.getUsername());
		if (passwordEncoder.matches(user.getPassword(), userdb.getPassword())) {
			return "SUCCESS";
		}
		return "FAILED";
	}

}
