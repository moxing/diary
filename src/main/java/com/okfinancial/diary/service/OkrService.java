package com.okfinancial.diary.service;

import java.util.Calendar;
import com.okfinancial.diary.domain.Okr;
import com.okfinancial.diary.domain.User;

public interface OkrService {
	
	Okr save(Okr okr);
	
	Okr findById(Long id);
	
	Okr findByUserAtQuarter(User user, Calendar calendar);
	
}
