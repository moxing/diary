package com.okfinancial.diary.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DayPlan extends AbstractEntity {
    
	public enum STATUS{
        admin, user;
    }	
	
	@ManyToOne(fetch=FetchType.LAZY)  
    @JoinColumn(name="week_plan_id")  
	private WeekPlan weekPlan;
	
	@ManyToOne(fetch=FetchType.LAZY)  
    @JoinColumn(name="user_id")  
	private User user;
	
	private String planContent;
	
	@Enumerated(EnumType.ORDINAL)
	private STATUS status;
	
	private Date planDate;
	
	private String remark;
	
	private String leaderRemark;
	
	public DayPlan() {
	}

	public WeekPlan getWeekPlan() {
		return weekPlan;
	}

	public void setWeekPlan(WeekPlan weekPlan) {
		this.weekPlan = weekPlan;
	}

	public String getPlanContent() {
		return planContent;
	}

	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public void setPlanDate(Date planDate) {
		this.planDate = planDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLeaderRemark() {
		return leaderRemark;
	}

	public void setLeaderRemark(String leaderRemark) {
		this.leaderRemark = leaderRemark;
	}

}
