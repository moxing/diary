package com.okfinancial.diary.web;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.okfinancial.diary.domain.DayPlan;
import com.okfinancial.diary.domain.WeekPlan;
import com.okfinancial.diary.service.WeekPlanService;

@RestController
@RequestMapping(value="/weekplan")
public class WeekPlanController extends AbstractController {
	
	@Autowired
	private WeekPlanService weekPlanService;
	
	@JsonView(VoFilter.View.class) 
	@RequestMapping(method=RequestMethod.GET)
	public WeekPlan index(){
		WeekPlan weekPlan = weekPlanService.findByUserAtDate(this.getUser(), new Date());
		List<DayPlan> list = weekPlan.getDayPlans();
		for (DayPlan dayPlan : list) {
			dayPlan.getReviver();
		}
		return weekPlan;
	}
	
	@JsonView(VoFilter.View.class)
	@RequestMapping(value="/next",method=RequestMethod.GET)
	public WeekPlan next(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.WEEK_OF_YEAR, +1);
		return weekPlanService.findByUserAtDate(this.getUser(), calendar.getTime());
	}
}
