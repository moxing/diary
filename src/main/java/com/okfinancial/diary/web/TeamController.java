package com.okfinancial.diary.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/team")
public class TeamController {

	@RequestMapping(method=RequestMethod.GET)
	public String team(){
		return "1";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String save(){
		return "2";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable Long id){
		return "2";
	}
}
