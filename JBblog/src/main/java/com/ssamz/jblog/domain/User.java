package com.ssamz.jblog.domain;

import java.sql.Timestamp;



import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USERS")
public class User {
	// 기본키에 대응하는 식별자 변수
	@Id
	// 1부터 시작하여 자동으로 1씩 증가하도록 증가 전략 설정
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id; 		 // 회원 일련번호
	
	@Column(nullable = false, length = 50, unique = true)
	private String username; // 아이디
	
	@Column(length = 100)
	private String password; // 패스워드
	
	@Column(nullable = false, length = 100)
	private String email;    // 이메일
	
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	@CreationTimestamp // 현재시간이 기본값으로 등록되도록 설정
	private Timestamp createDate;
}
