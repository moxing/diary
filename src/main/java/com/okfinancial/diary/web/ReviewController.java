package com.okfinancial.diary.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.okfinancial.diary.domain.DayPlan;
import com.okfinancial.diary.domain.DayPlanReview;
import com.okfinancial.diary.service.ReviewService;

@RestController
@RequestMapping(value="/review")
public class ReviewController extends AbstractController {
	
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping(value="/dayplan/{id}",method={RequestMethod.POST,RequestMethod.PUT},produces=MediaType.APPLICATION_JSON_VALUE)
	@JsonView(VoFilter.View.class)
	DayPlanReview save(@PathVariable("id") DayPlan dayPlan, @RequestBody DayPlanReview review){
		review.setDayPlan(dayPlan);
		review.setReviewer(this.getUser());
		return reviewService.saveReview(review);
	}
}
