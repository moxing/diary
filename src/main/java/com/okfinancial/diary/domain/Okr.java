package com.okfinancial.diary.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.okfinancial.diary.web.VoFilter;

@Entity
public class Okr extends AbstractEntity {
    
	public enum STATUS{
        admin, user;
    }	
	
	@JsonView(VoFilter.View.class)
	@ManyToOne(fetch=FetchType.LAZY, optional=true)  
    @JoinColumn(name="user_id")
	private User user;
	
	@JsonView(VoFilter.View.class)
	private String content;
	
	@JsonView(VoFilter.View.class)
	private Date quarter;
	
	@Enumerated(EnumType.ORDINAL)
	private STATUS status;
	
	protected Okr(){
		super();
	}
	
	public Okr(String content,User user, Date quarter) {
		this.content = content;
		this.user = user;
		this.quarter = quarter;
	}

	public Okr(String content) {
		this.content = content;
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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getQuarter() {
		return quarter;
	}


	public void setQuarter(Date quarter) {
		this.quarter = quarter;
	}
}
