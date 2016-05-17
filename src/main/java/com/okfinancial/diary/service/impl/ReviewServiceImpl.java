package com.okfinancial.diary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.okfinancial.diary.dao.ReviewRepository;
import com.okfinancial.diary.domain.DayPlanReview;
import com.okfinancial.diary.service.ReviewService;

@Component("reviewService")
@Transactional
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Override
	public DayPlanReview saveReview(DayPlanReview review) {
		return this.reviewRepository.save(review);
	}

}
