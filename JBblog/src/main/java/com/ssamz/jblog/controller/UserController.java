package com.ssamz.jblog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssamz.jblog.domain.RoleType;
import com.ssamz.jblog.domain.User;
import com.ssamz.jblog.exception.JBlogException;
import com.ssamz.jblog.persistence.UserRepository;

import jakarta.transaction.Transactional;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	// 회원가입
	@PostMapping("/user")
	public @ResponseBody String insertUser(@RequestBody User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return user.getUsername() + "회원가입 성공";
	}
	
	// 회원 조회
	@GetMapping("/user/get/{id}")
	public @ResponseBody User getUser(@PathVariable int id) {
		// 특정 id(회원번호)에 해당하는 User 객체 변환
		// 검색된 회원이 없을 경우 예외를 리턴하여 처리한다
		User findUser = userRepository.findById(id).orElseThrow(()->{ // 추상 메소드가 하나만 존재하는 인터페이스는 람다식으로 간단하게 표현 할 수 있다 
			return new JBlogException(id + "번 회원이 없습니다.");
		  //userRepository.findById(id).orElseThrow(new Supplier<JBlogException>() {
		  //@Override
		  //public JBlogException get() {
			  //return new JBlogException(id + "번 회원이 없습니다.");
			//}
		});
		return findUser;
	}
	
	// 회원 수정
	@Transactional
	@PutMapping("/user")
	public @ResponseBody String updateUser(@RequestBody User user) {
		User findUser = userRepository.findById(user.getId()).orElseThrow(()->{
			return new JBlogException(user.getId() + "번 회원이 없습니다.");
		});
		findUser.setUsername(user.getUsername());
		findUser.setPassword(user.getPassword());
		findUser.setEmail(user.getEmail());
		
//		userRepository.save(findUser);
		return "회원수정 성공";
	} 
}