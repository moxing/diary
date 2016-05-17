package com.okfinancial.diary.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonView;
import com.okfinancial.diary.web.VoFilter;

@MappedSuperclass
public class AbstractEntity {

	@Id
	@GeneratedValue
	@JsonView(VoFilter.View.class)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)  
	@Column(updatable = false)  
	@org.hibernate.annotations.CreationTimestamp 
	private Date created_date;

	@Temporal(TemporalType.TIMESTAMP)  
	@Column(updatable = true)  
	@org.hibernate.annotations.UpdateTimestamp 
	private Date modify_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getModify_date() {
		return modify_date;
	}

	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

}
