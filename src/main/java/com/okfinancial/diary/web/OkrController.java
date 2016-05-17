package com.okfinancial.diary.web;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.okfinancial.diary.domain.Okr;
import com.okfinancial.diary.service.OkrService;
import com.okfinancial.diary.service.UserService;

@RestController
@RequestMapping(value="/okr")
public class OkrController extends AbstractController {
	@Autowired
	private OkrService okrService;
	@Autowired
	private UserService userService;

	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@JsonView(VoFilter.DetailView.class) 
	Okr okrById(@PathVariable("id") Okr okr){
		return okr;
	}
	
	@RequestMapping(value="/current",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@JsonView(VoFilter.DetailView.class) 
	Okr okrByCurrentQuarter(){
		Calendar calendar = Calendar.getInstance();
		Okr okr = okrService.findByUserAtQuarter(this.getUser(), calendar);
		if(okr==null){
			okr = okrService.save(new Okr(null,this.getUser(),calendar.getTime()));
		}
		return okr;
	}

	@RequestMapping(value="/next",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@JsonView(VoFilter.DetailView.class) 
	Okr okrByNextQuarter(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONDAY, +3);
		Okr okr = okrService.findByUserAtQuarter(this.getUser(), calendar);
		if(okr==null){
			okr = okrService.save(new Okr(null,this.getUser(),calendar.getTime()));
		}
		return okr;
	}	
	
	@RequestMapping(method={RequestMethod.POST,RequestMethod.PUT},produces=MediaType.APPLICATION_JSON_VALUE)
	@JsonView(VoFilter.DetailView.class) 
	Okr saveOkr(@RequestBody Okr okr){
		if(okr.getId()>0){
			String content = okr.getContent();
			okr = okrService.findById(okr.getId());
			okr.setContent(content);
		}else{
			okr.setUser(this.getUser());
		}
		return okrService.save(okr);
	}	
}
