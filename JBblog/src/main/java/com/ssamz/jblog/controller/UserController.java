package com.ssamz.jblog.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssamz.jblog.domain.User;
import com.ssamz.jblog.dto.ResponseDTO;
import com.ssamz.jblog.dto.UserDTO;
import com.ssamz.jblog.service.UserService;

@Controller
public class UserController {
	// 로그인 요청
	@GetMapping("/auth/login")
	public String login() {
		return "system/login";
	}
	
	//회원가입
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/auth/insertUser")
	public String insertUser() {
//		System.out.println(9/0); // 에러 테스트
		return "user/insertUser";
	}
	
	@PostMapping("/auth/insertUser")
	public @ResponseBody ResponseDTO<?> insertUser(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult){
		//userDTO -> User 객체로 변환
		User user = modelMapper.map(userDTO, User.class);
		User findUser = userService.getUser(user.getUsername());
		
		
		if(findUser.getUsername() == null) {
			userService.insertUser(user);
			return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "가입성공.");
		} else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), user.getUsername() + "님은 이미 회원입니다.");
		}		
	}
	
	@GetMapping("/user/updateUser")
	public String updateUser() {
		return "user/updateUser";
	}
	
	@PutMapping("/user")
	public @ResponseBody ResponseDTO<?> updateUser(@RequestBody User user){
		userService.updateUser(user);
		return new ResponseDTO<>(HttpStatus.OK.value(), user.getUsername() + "수정 완료");
	}
	
	
}