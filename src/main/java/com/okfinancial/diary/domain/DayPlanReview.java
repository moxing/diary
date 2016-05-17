package com.okfinancial.diary.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.okfinancial.diary.web.VoFilter;

@Entity
public class DayPlanReview extends AbstractEntity {
	
	@ManyToOne(fetch=FetchType.LAZY, optional=true)  
    @JoinColumn(name="user_id")
	@JsonView(VoFilter.View.class)
	private User reviewer;
	
	@OneToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn(name="day_plan_id")
	private DayPlan dayPlan;
	
	private int level;
	
	@JsonView(VoFilter.View.class)
	private String content;
	
	public DayPlanReview() {
	}

	public User getReviewer() {
		return reviewer;
	}

	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}

	public DayPlan getDayPlan() {
		return dayPlan;
	}

	public void setDayPlan(DayPlan dayPlan) {
		this.dayPlan = dayPlan;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
