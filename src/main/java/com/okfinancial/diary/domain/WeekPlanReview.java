package com.okfinancial.diary.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WeekPlanReview extends AbstractEntity {
	
	@ManyToOne(fetch=FetchType.LAZY, optional=true)  
    @JoinColumn(name="user_id")  
	private User Reviewer;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=true)
	@JoinColumn(name="week_plan_id")
	private WeekPlan weekPlan;
	
	private int level;
	
	private String content;
	
	public WeekPlanReview() {
	}

	public User getReviewer() {
		return Reviewer;
	}

	public void setReviewer(User reviewer) {
		Reviewer = reviewer;
	}

	public WeekPlan getWeekPlan() {
		return weekPlan;
	}

	public void setWeekPlan(WeekPlan weekPlan) {
		this.weekPlan = weekPlan;
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
