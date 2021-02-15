package com.mmm.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_focus_country")
public class FocusCountry {

	public FocusCountry() {
	}

	public FocusCountry(long focusCtryId) {
		super();
		this.focusCtryId = focusCtryId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FOCUS_CTRY_ID")
	@NaturalId
	private long focusCtryId;

	@Column(name = "FOCUS_CTRY_NAME")
	private String focusCountryName;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "asgnd_ctrys")
	@JsonIgnore
	Set<UserProfile> users = new HashSet<UserProfile>();

	public long getFocusCtryId() {
		return focusCtryId;
	}

	public void setFocusCtryId(long focusCtryId) {
		this.focusCtryId = focusCtryId;
	}

	public String getFocusCountryName() {
		return focusCountryName;
	}

	public void setFocusCountryName(String focusCountryName) {
		this.focusCountryName = focusCountryName;
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
		FocusCountry ctry = (FocusCountry) o;
		return Objects.equals(focusCtryId, ctry.focusCtryId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(focusCtryId);
	}

	@Override
	public String toString() {
		return "FocusCountry [focusCtryId=" + focusCtryId + ", focusCountryName=" + focusCountryName + ", users="
				+ users + "]";
	}
}
