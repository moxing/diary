package com.okfinancial.diary.service;

import java.util.Date;

import com.okfinancial.diary.domain.Okr;

public interface OkrService {
	
	Okr save(Okr okr);
	
	Okr findById(Long id);
	
	Okr findByDate(Date date);
	
}
