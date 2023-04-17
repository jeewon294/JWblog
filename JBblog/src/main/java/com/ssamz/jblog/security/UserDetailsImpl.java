package com.ssamz.jblog.security;

import java.util.Collection;
import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ssamz.jblog.domain.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails{
	private static final long seriaVersionUID= 1L;
	private User user; //Users 테이블과 매핑된 엔티티
	
	public UserDetailsImpl(User user) {
		this.user = user;
	}
	
	@Override
	public String getPassword() {
		// noop: 암호화하지 않기 위한 설정
		return "{noop}" + user.getPassword();
	}
	
	@Override
	public String getUsername() {
		return user.getUsername();
	}
	
	// 계정이 만료되지 않았는지 반환
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	// 계정이 잠겨있는지 반환
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	// 비밀번호가 만료되지 않았는지 반환
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	// 계정이 활성화되었는지 반환
	@Override
	public boolean isEnabled() {
		return true;
	}
	 
	// 계정이 가지고 있는 권한 목록 저장하여 반환
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		// 권한 목록
		Collection<GrantedAuthority> roleList = new ArrayList();
		// 권한 목록 설정
		roleList.add(()-> {
				return "ROLE_" + user.getRole();
		});
		
		return roleList;
	}
}
