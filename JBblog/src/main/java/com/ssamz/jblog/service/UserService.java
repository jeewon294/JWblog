package com.ssamz.jblog.service;

//import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssamz.jblog.domain.RoleType;
import com.ssamz.jblog.domain.User;
import com.ssamz.jblog.persistence.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void insertUser(User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	
	@Transactional(readOnly = true)
	public User getUser(String username) {
//      방법1 람다식
		User findUser = userRepository.findByUsername(username).orElseGet(()->{
			return new User();
		});
		
//      방법2		
//		//검색 결과가 없을 때 빈 User 객체 반환
//		User findUser = userRepository.findByUsername(name).orElseGet(new Supplier<User>() {
//			@Override
//			public User get() {
//				return new User();
//			}
//		});
		
		return findUser;
	}
}
