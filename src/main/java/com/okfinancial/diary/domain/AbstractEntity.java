package com.okfinancial.diary.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;
import com.okfinancial.diary.web.VoFilter;

@MappedSuperclass 
public class AbstractEntity {

	@Id
	@GeneratedValue
	@JsonView(VoFilter.DetailView.class)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)  
	@Column(updatable = false)  
	@org.hibernate.annotations.CreationTimestamp 
	private Date created_date;

	@Temporal(TemporalType.TIMESTAMP)  
	@Column(updatable = true)  
	@org.hibernate.annotations.UpdateTimestamp 
	private Date modify_date;

}
