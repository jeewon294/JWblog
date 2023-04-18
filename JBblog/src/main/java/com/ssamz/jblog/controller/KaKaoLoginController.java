package com.ssamz.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssamz.jblog.domain.User;
import com.ssamz.jblog.service.KaKaoLoginService;
import com.ssamz.jblog.service.UserService;

@Controller
public class KaKaoLoginController {
	@Autowired
	private KaKaoLoginService kakaoLoginService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Value("${kakao:kakao123}")
	private String kakaoPassword;
	
	@GetMapping("/oauth/kakao")
	public String kakaoCallback(String code) {
		// 1. 인증 서버로부터 받은 CODE를 이용하여 엑세스 토큰을 얻는다. 
		String accessToken = kakaoLoginService.getAccessToken(code);
		
		// 2. 액세스 토큰을 이용하여 사용자 정보를 얻어온다.
		User kakaoUser = kakaoLoginService.getUserInfo(accessToken);
		
		// 3. 기존회원이 아니면 신규회원으로 등록한다. 
		User findUser = userService.getUser(kakaoUser.getUsername());
		if(findUser.getUsername() == null) {
			userService.insertUser(kakaoUser);
		}
		
		// 4. 카카오로부터 받은 사용자 정보를 기반으로 인증을 처리한다. 
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(kakaoUser.getUsername(), kakaoPassword);
		
		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		
		return "redirect:/";
		
		/*
		 * // 응답을 콘솔과 브라우저에서 출력한다. System.out.println(accessToken); return accessToken;
		 */
	}
}
