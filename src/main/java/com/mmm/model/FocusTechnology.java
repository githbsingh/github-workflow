package com.mmm.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_focus_technology")
public class FocusTechnology {

	public FocusTechnology() {
	}

	public FocusTechnology(long focusTechId) {
		super();
		this.focusTechId = focusTechId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FOCUS_TECH_ID")
	@NaturalId
	private long focusTechId;
	
	@Column(name = "FOCUS_TECH_NAME")
	private String focusTechnologyName;
	
	@ManyToMany(mappedBy = "asgnd_techs")
	@JsonIgnore
	Set<UserProfile> users = new HashSet<UserProfile>();

	public long getFocusTechId() {
		return focusTechId;
	}

	public void setFocusTechId(long focusTechId) {
		this.focusTechId = focusTechId;
	}

	public String getFocusTechnologyName() {
		return focusTechnologyName;
	}

	public void setFocusTechnologyName(String focusTechnologyName) {
		this.focusTechnologyName = focusTechnologyName;
	}

	public Set<UserProfile> getUsers() {
		return users;
	}

	public void setUsers(Set<UserProfile> users) {
		this.users = users;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		FocusTechnology tech = (FocusTechnology) o;
		return Objects.equals(focusTechId, tech.focusTechId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(focusTechId);
	}

	@Override
	public String toString() {
		return "FocusTechnology [focusTechId=" + focusTechId + ", focusTechnologyName=" + focusTechnologyName
				+ ", users=" + users + "]";
	}
	
}
