package com.okfinancial.diary.web;

import java.util.List;

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
	@JsonView(VoFilter.View.class) 
	User save(@RequestBody User user){
		return userService.saveUser(user);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@JsonView(VoFilter.View.class) 
	User user(@PathVariable("id") User user){
		return user;
	}
	
	@RequestMapping(value="/name/{name}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@JsonView(VoFilter.View.class) 
	User userByEmail(@PathVariable("name") String name){
		return userService.getUser(name);
	}
	
	@RequestMapping(value="/noleader",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@JsonView(VoFilter.View.class) 
	List<User> userNoLeader(){
		return userService.getUserIsNotLeader();
	}
	
	@RequestMapping(value="/{id}/leader/{leaderId}",method=RequestMethod.PUT)
	@JsonView(VoFilter.View.class) 
	User appointLeader(@PathVariable("id") User user, @PathVariable("leaderId") User leader){
		user.setLeader(leader);
		return userService.saveUser(user);
	}
	
	@RequestMapping(value="/{id}/leader/{leaderId}",method=RequestMethod.DELETE)
	void deleteUser(@PathVariable("id") User user, @PathVariable("leaderId") User leader){
		userService.deleteUser(user,leader);
	}
}
