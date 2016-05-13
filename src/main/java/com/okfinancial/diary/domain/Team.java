package com.okfinancial.diary.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Team extends AbstractEntity {

	@OneToOne
	@JoinColumn(name="user_id")
	private User leader;

	private String name;
	
	@OneToMany(mappedBy="team")
	private List<User> members;
	
	public Team() {
	}
	
	public User getLeader() {
		return leader;
	}

	public void setLeader(User leader) {
		this.leader = leader;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

}
