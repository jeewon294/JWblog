package com.ssamz.jblog.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	private int id; 		 // 회원 일련번호
	private String username; // 아이디
	private String password; // 패스워드
	private String email;    // 이메일
}
