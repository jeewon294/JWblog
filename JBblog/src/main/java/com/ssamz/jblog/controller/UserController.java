package com.ssamz.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssamz.jblog.domain.RoleType;
import com.ssamz.jblog.domain.User;
import com.ssamz.jblog.persistence.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/user")
	public @ResponseBody String insertUser(@RequestBody User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return user.getUsername() + "회원가입 성공";
	}
	
	@GetMapping("/user/get/{id}")
	public @ResponseBody User getUser(@PathVariable int id) {
		//특정 id(회원번호)에 해당하는 User 객체 변환
		User findUser = userRepository.findById(id).get();
		return findUser;
	}
	
}
