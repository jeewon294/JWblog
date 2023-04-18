package com.ssamz.jblog.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class KaKaoLoginService {
	public String getAccessToken(String code) {
		// HttpHeaders 생성(MIME 종류)
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		// HttpBody 생성(4개의 필수 매개변수 설정)
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("grant_type", "authorization_code");
		body.add("client_id", "87c669ddbe9f7bec94036af629495f28");
		body.add("redirect_uri", "http://localhost:8092/oauth/kakao");
		body.add("code", code);
		
		// Httpheaders와 HttpBody가 설정된 HttpEntity 객체 생성
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(body, header);
		
		// RestTemplate을 이용하면 	브라우저 없이 HTTP 요청을 처리할 수 있다.
		RestTemplate restTemplate = new RestTemplate();
		
		// HTTP 요청 및 응답받기
		ResponseEntity<String> responseEntity = restTemplate.exchange("https://kauth.kakao.com/oauth/token", // 엑세스 토큰 요청 URL
				HttpMethod.POST, 	// 요청 방식
				requestEntity, 		// 요청 헤어와 바디
				String.class		// 응답받을 타입
		);
		
		return responseEntity.getBody();
			
	}
}
