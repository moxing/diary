package com.okfinancial.diary.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.okfinancial.diary.dao.WeekPlanRepository;
import com.okfinancial.diary.domain.User;
import com.okfinancial.diary.domain.WeekPlan;
import com.okfinancial.diary.service.WeekPlanService;

@Component("weekPlanService")
@Transactional
public class WeekPlanServiceImpl implements WeekPlanService {

	@Autowired
	private WeekPlanRepository weekPlanRepository;
	
	@Override
	public WeekPlan findByUserAtDate(User user, Date date) {
		WeekPlan weekPlan = this.weekPlanRepository.findByUserAndDate(user, date);
		if(weekPlan==null){
			weekPlan = new WeekPlan(user,date);
			weekPlan = this.weekPlanRepository.save(weekPlan);
		}
		return weekPlan;
	}

}
