package com.ssamz.jblog.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ssamz.jblog.security.OAuth2UserDetailsServiceImpl;
import com.ssamz.jblog.security.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class JBlogWebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private OAuth2UserDetailsServiceImpl oauth2DetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// 사용자가 입력한 username으로 User 객체를 검색하고 password를 비교한다.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	
	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		// 인증 없이 접근을 허용하는 경로
		http.authorizeRequests().antMatchers("/webjars/**", "/js/**", "/image/**", "/", "/auth/**", "/oauth/**").permitAll();
		// 나머지 경로는 인증이 필요하다.
		http.authorizeRequests().anyRequest().authenticated();
		/*
		 * // 기본 로그인 화면 제공 http.formLogin();
		 */
		
		// CSRF 토큰을 받지 않음
		http.csrf().disable();
		
		// 사용자 정의 로그인 화면 제공
		http.formLogin().loginPage("/auth/login");
		
		
		// 로그인 요청 URI를 변경한다. 
		http.formLogin().loginProcessingUrl("/auth/securitylogin");
		
		// 로그아웃 설정
		http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");
		
		// OAuth2 로그인 설정
		http.oauth2Login()
		// OAuth2로 사용자 정보를 가져온다. 
		.userInfoEndpoint()
		// userInfoEndpoint()로 가져온 사용자 정보를 이용해서
		// auth2DetailsService 객체로 사후 처리한다. 
		.userService(oauth2DetailsService);
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
}
