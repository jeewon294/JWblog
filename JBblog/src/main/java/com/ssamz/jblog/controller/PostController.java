package com.ssamz.jblog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssamz.jblog.domain.Post;
import com.ssamz.jblog.dto.PostDTO;
import com.ssamz.jblog.dto.ResponseDTO;
import com.ssamz.jblog.service.PostService;
import com.ssamz.jblog.domain.User;
@Controller
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/post/insertPost")
	public String insertPost() {
		return "post/insertPost";
	}
	
	
	
	@PostMapping("/post")
	public @ResponseBody ResponseDTO<?> insertPost(@Valid @RequestBody PostDTO postDTO, BindingResult bindingResult ,HttpSession session){
		//PostDTO 객체에 대한 유효성 검사
		if(bindingResult.hasErrors()) {
			//에러가 하나라도 있다면 에러 메시지를 Map에 등록
			Map<String, String> errorMap = new HashMap<>();
			for(FieldError error : bindingResult.getFieldErrors()) {
				errorMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(),errorMap);
		}
		// PostDTO -> Post 객체로 변환
		Post post = modelMapper.map(postDTO, Post.class);
		
		// Post 객체를 영속화하기 전 연관된 User 엔티티 설정
		User principal = (User) session.getAttribute("principal");
		post.setUser(principal);
		post.setCnt(0);
		
		postService.insertPost(post);
		
		return new ResponseDTO<>(HttpStatus.OK.value(), "새로운 포스트를 등록했습니다.");
	}
	
	@GetMapping({"","/"})
	public String getPostList(Model model, @PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable) {
		model.addAttribute("postList", postService.getPostList(pageable));
		return "index";
	}
	
	@GetMapping("/post/{id}")
	public String getPost(@PathVariable int id, Model model) {
		model.addAttribute("post", postService.getPost(id));
		return "post/getPost";
	}
	
	@GetMapping("/post/updatePost/{id}")
	public String updatePost(@PathVariable int id, Model model) {
		model.addAttribute("post", postService.getPost(id));
		return "post/updatePost";
	}
	
	@PutMapping("/post")
	public @ResponseBody ResponseDTO<?> updatePost(@RequestBody Post post){
		postService.updatePost(post);
		return new ResponseDTO<>(HttpStatus.OK.value(), post.getId() + "번 포스트를 수정하였습니다.");
	}
	
	@DeleteMapping("/post/{id}")
	public @ResponseBody ResponseDTO<?> deletePost(@PathVariable int id){
		postService.deletePost(id);
		return new ResponseDTO<>(HttpStatus.OK.value(), id + "번 포스트를 삭제하였습니다.");
	}

}
