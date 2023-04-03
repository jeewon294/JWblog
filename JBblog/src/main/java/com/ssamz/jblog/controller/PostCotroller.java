package com.ssamz.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostCotroller {
	@GetMapping({"","/"})
		public String getPostList(){
			return "index";
		}	
}
