package com.okfinancial.diary.service;

import java.util.Date;
import java.util.List;

import com.okfinancial.diary.domain.DayPlan;
import com.okfinancial.diary.domain.User;

public interface DayPlanService {
	
	public List<DayPlan> saveAll(List<DayPlan> list);
	
	public List<DayPlan> memberDayPlan(User leader, Date date);

	public DayPlan save(DayPlan dayPlan);
}
