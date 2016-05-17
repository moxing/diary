package com.okfinancial.diary.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.okfinancial.diary.dao.DayPlanRepository;
import com.okfinancial.diary.domain.DayPlan;
import com.okfinancial.diary.domain.User;
import com.okfinancial.diary.service.DayPlanService;

@Component("dayPlanService")
@Transactional
public class DayPlanServiceImpl implements DayPlanService {
	
	@Autowired
	private DayPlanRepository dayPlanRepository;
	
	@Override
	public List<DayPlan> saveAll(List<DayPlan> list) {
		return (List<DayPlan>) this.dayPlanRepository.save(list);
	}

	@Override
	public DayPlan save(DayPlan dayPlan) {
		return this.dayPlanRepository.save(dayPlan);
	}

	@Override
	public List<DayPlan> memberDayPlan(User leader, Date date) {
		return this.dayPlanRepository.findByLeaderAndDate(leader, date);
	}

}
