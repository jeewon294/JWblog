package com.ssamz.jblog.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssamz.jblog.domain.User;

@RestController
public class RESTController {

	//Get : Select
	@GetMapping("/jblog")
	public User httpGet() {
		User findUser = User.builder()
				.id(1)
				.username("gurum")
				.password("222")
				.email("gurum@gamil.com")
			.build();
		return findUser;
	}
	
	//Post : Insert
	@PostMapping("/jblog")
	public String httpPost(@RequestBody User user) {
		return "post 요청처리 :" + user.toString();
	}
	
	//Put : Update
	@PutMapping("/jblog")
	public String httpPut(@RequestBody User user) {
		return "put 요청처리 :" + user.toString();
	}
	
	//Delete : Delete
	@DeleteMapping("/jblog")
	public String httpDelete(@RequestParam int id) {
		return "delete 요청처리:" + id;
	}
}
