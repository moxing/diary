package com.okfinancial.diary.service;

import com.okfinancial.diary.domain.User;

public interface UserService {
	
	public User getUser(String name);
	
	public User getUser(Long id);
	
	public User saveUser(User user);

}
