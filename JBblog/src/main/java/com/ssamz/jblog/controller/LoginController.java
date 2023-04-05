package com.ssamz.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/auth/login")
	public String login() {
		return "system/login";
	}
}
