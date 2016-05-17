package com.okfinancial.diary.service;

import java.util.List;

import com.okfinancial.diary.domain.User;

public interface UserService {
	
	public User getUser(String name);
	
	public User getUser(Long id);
	
	public User saveUser(User user);
	
	public List<User> getUserIsNotLeader();
	
	public void deleteUser(User user,User leader);
	
}
