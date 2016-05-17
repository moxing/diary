package com.okfinancial.diary.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;
import com.okfinancial.diary.util.DateUtils;
import com.okfinancial.diary.web.VoFilter;

@Entity
public class WeekPlan extends AbstractEntity {

	@JsonView(VoFilter.View.class)
	@ManyToOne(fetch=FetchType.LAZY, optional=true)  
    @JoinColumn(name="user_id")  
	private User user;
	
	private int status;
	
	@JsonView(VoFilter.View.class)
	@Column(name="start_date") 
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@JsonView(VoFilter.View.class)
	@Column(name="end_date")
	@Temporal(TemporalType.TIMESTAMP)  
	private Date endDate;
	
	@JsonView(VoFilter.View.class)
	@Column(name="week_no")
	private int weekNo;
	
	@JsonView(VoFilter.View.class)
	@Column(name="month_no")
	private int monthNo;
	
	@JsonView(VoFilter.View.class)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "weekPlan")
	private List<DayPlan> dayPlans;
	
	private int level;
	
	public WeekPlan() {
		super();
	}
	
	public WeekPlan(User user, Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		this.startDate = DateUtils.getNowWeekMonday(date);
		this.endDate = DateUtils.getNowWeekSunday(date);
		this.monthNo = cal.get(Calendar.WEEK_OF_MONTH);
		this.weekNo = cal.get(Calendar.WEEK_OF_YEAR);
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<DayPlan> getDayPlans() {
		return dayPlans;
	}

	public void setDayPlans(List<DayPlan> dayPlans) {
		this.dayPlans = dayPlans;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getWeekNo() {
		return weekNo;
	}

	public void setWeekNo(int weekNo) {
		this.weekNo = weekNo;
	}

	public int getMonthNo() {
		return monthNo;
	}

	public void setMonthNo(int monthNo) {
		this.monthNo = monthNo;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
