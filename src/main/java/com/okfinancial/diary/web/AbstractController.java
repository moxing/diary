package com.okfinancial.diary.web;

import org.springframework.beans.factory.annotation.Autowired;

import com.okfinancial.diary.domain.User;
import com.okfinancial.diary.service.UserService;

public class AbstractController {
	
	@Autowired
	private UserService userService;
	
	private User user;

	protected User getUser() {
		if(user==null){
			this.user = userService.getUser(3L);
		}
		return this.user;
	}
	
	

}
