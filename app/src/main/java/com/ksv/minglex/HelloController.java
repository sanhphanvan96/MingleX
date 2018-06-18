
package com.ksv.minglex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/")
	public String index(Model model) {		
		return "index";
	}


	@RequestMapping("/login")
	public String login(Model model) {		
		return "login";
	}

	@RequestMapping("/profile")
	public String profile(Model model) {
		model.addAttribute("user", "Khanh");
		return "profile";
	}
}