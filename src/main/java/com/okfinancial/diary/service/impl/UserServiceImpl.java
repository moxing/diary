package com.okfinancial.diary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.okfinancial.diary.dao.UserRepository;
import com.okfinancial.diary.domain.User;
import com.okfinancial.diary.service.UserService;


@Component("userService")
@Transactional
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User getUser(String name) {
		return this.userRepository.findOneByName(name);
	}

	@Override
	public User getUser(Long id) {
		return this.userRepository.findOne(id);
	}

	@Override
	public User saveUser(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public List<User> getUserIsNotLeader() {
		return this.userRepository.findByLeaderIsNull();
	}

	@Override
	public void deleteUser(User user,User leader) {
//		if(user.getMembers().size()>0){
//			leader.setMembers(user.getMembers());
			user.getMembers().clear();
//		}
//		if(leader!=null){
//			this.userRepository.save(leader);
//		}
		user.setState(1);
		this.userRepository.save(user);
	}
}
