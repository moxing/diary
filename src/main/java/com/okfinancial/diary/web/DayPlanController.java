package com.okfinancial.diary.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.okfinancial.diary.domain.DayPlan;
import com.okfinancial.diary.domain.User;
import com.okfinancial.diary.domain.WeekPlan;
import com.okfinancial.diary.service.DayPlanService;
import com.okfinancial.diary.service.UserService;

@RestController
@RequestMapping(value="/dayplan")
public class DayPlanController  extends AbstractController{

	@Autowired
	private UserService userService;

	@Autowired
	private DayPlanService dayPlanService;
	
	@RequestMapping(value="/leader/{id}/day/{date}",method=RequestMethod.GET)
	@JsonView(VoFilter.View.class) 
	List<DayPlan> membersDayPlan(@PathVariable("id") User leader, @PathVariable("date") Date date){
		return dayPlanService.memberDayPlan(leader, date);
	}
	
	@RequestMapping(value="/weekplan/{id}",method=RequestMethod.POST)
	@JsonView(VoFilter.View.class) 
	List<DayPlan> saveDayPlan(@PathVariable("id") WeekPlan weekPlan ,@RequestBody List<DayPlan> list){
		for (DayPlan dayPlan : list) {
			dayPlan.setWeekPlan(weekPlan);
			dayPlan.setUser(this.getUser());
		}
		return dayPlanService.saveAll(list);
	}
	
	@RequestMapping(value="/{id}",method={RequestMethod.POST,RequestMethod.PUT})
	@JsonView(VoFilter.View.class) 
	DayPlan dayPlan(@PathVariable("id") DayPlan oriDayPlan ,@RequestBody DayPlan dayPlan){
		oriDayPlan.setPlanContent(dayPlan.getPlanContent());
		oriDayPlan.setStatus(dayPlan.getStatus());
		oriDayPlan.setRemark(dayPlan.getRemark());
		return dayPlanService.save(oriDayPlan);
	}
}
