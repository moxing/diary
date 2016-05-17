package com.okfinancial.diary.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.okfinancial.diary.dao.OkrRepository;
import com.okfinancial.diary.domain.Okr;
import com.okfinancial.diary.domain.User;
import com.okfinancial.diary.service.OkrService;

@Component("okrService")
@Transactional
public class OkrServiceImpl implements OkrService {
	
	@Autowired
	private OkrRepository okrRepository;

	@Override
	public Okr save(Okr okr) {
		return this.okrRepository.save(okr);
	}

	@Override
	public Okr findById(Long id) {
		return this.okrRepository.findOne(id);
	}

	@Override
	public Okr findByUserAtQuarter(User user, Calendar calendar) {
		int quarter = (calendar.get(Calendar.MONTH)/3)+1;
		return this.okrRepository.findByUserAtQuarter(user, calendar.get(Calendar.YEAR), quarter);
	}

}
