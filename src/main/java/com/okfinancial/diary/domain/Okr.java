package com.okfinancial.diary.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Okr extends AbstractEntity {
    
	public enum STATUS{
        admin, user;
    }	
	
	@ManyToOne(fetch=FetchType.LAZY, optional=true)  
    @JoinColumn(name="user_id")  
	private User user;
	
	private String content;
	
	private Date quarter;
	
	@Enumerated(EnumType.ORDINAL)
	private STATUS status;
	
	
	public Okr() {
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
