package com.okfinancial.diary.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.okfinancial.diary.domain.User;
import com.okfinancial.diary.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method={RequestMethod.POST,RequestMethod.PUT},produces=MediaType.APPLICATION_JSON_VALUE)
	@JsonView(VoFilter.DetailView.class)
	User save(@RequestBody User user){
		return userService.saveUser(user);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@JsonView(VoFilter.DetailView.class) 
	User user(@PathVariable long id){
		User user = userService.getUser(id);
		return user;
	}	
}
