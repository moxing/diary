package com.okfinancial.diary.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.okfinancial.diary.service.UserService;

@RestController
public class WeekPlanController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/week",method=RequestMethod.GET)
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/week/add",method=RequestMethod.GET)
	public String newWeekPlan(){
		return "week";
	}
}
