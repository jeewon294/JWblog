package com.ssamz.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssamz.jblog.service.KaKaoLoginService;

@Controller
public class KaKaoLoginController {
	@Autowired
	private KaKaoLoginService kakaoLoginService;
	
	@GetMapping("/oauth/kakao")
	public @ResponseBody String kakaoCallback(String code) {
		// 1. 인증 서버로부터 받은 CODE를 이용하여 엑세스 토큰을 얻는다. 
		String accessToken = kakaoLoginService.getAccessToken(code);
		
		// 응답을 콘솔과 브라우저에서 출력한다. 
		System.out.println(accessToken);
		return accessToken;
	}
}
