package com.okfinancial.diary.service;

import java.util.Date;

import com.okfinancial.diary.domain.User;
import com.okfinancial.diary.domain.WeekPlan;

public interface WeekPlanService {
	
	public WeekPlan findByUserAtDate(User user, Date date);
}
