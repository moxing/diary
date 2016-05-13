package com.okfinancial.diary.domain;


import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.okfinancial.diary.util.DigestUtils;
import com.okfinancial.diary.web.VoFilter;

@Entity
public class User extends AbstractEntity {
	
	@JsonView(VoFilter.View.class)
	@Column(nullable = false)
	private String name;
	
	
	@Column(nullable = false)
	private String password;
	
	@JsonView(VoFilter.DetailView.class)
	@Column(nullable = false)
	private int level;
	
	@JsonView(VoFilter.DetailView.class)
	@Column(nullable = false)
	private int state;

	@JsonView(VoFilter.DetailView.class)
	@Column(nullable = false)
	private String email;
    
	@ManyToOne
	@JoinColumn(name="team_id")
    private Team team;
	
	protected User(){
		super();
	}
	
	public User(String name,String password,String email) throws NoSuchAlgorithmException{
		super();
		this.name = name;
		this.password = DigestUtils.hash256(password);
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
