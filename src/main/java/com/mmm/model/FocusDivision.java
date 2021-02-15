/**
 * 
 */
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

/**
 * @author a2krjzz
 *
 */
@Entity
@Table(name = "t_focus_div")
public class FocusDivision {

	public FocusDivision() {
	}

	public FocusDivision(long focusDivId) {
		super();
		this.focusDivId = focusDivId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FOCUS_DIV_ID")
	@NaturalId
	private long focusDivId;

	@Column(name = "FOCUS_DIV_NAME")
	private String focusDivisionName;

	@ManyToMany(mappedBy = "asgnd_divs",fetch = FetchType.LAZY)
	@JsonIgnore 
	Set<UserProfile> users = new HashSet<UserProfile>();

	public long getFocusDivId() {
		return focusDivId;
	}

	public void setFocusDivId(long focusDivId) {
		this.focusDivId = focusDivId;
	}

	public String getFocusDivisionName() {
		return focusDivisionName;
	}

	public void setFocusDivisionName(String focusDivisionName) {
		this.focusDivisionName = focusDivisionName;
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
		FocusDivision div = (FocusDivision) o;
		return Objects.equals(focusDivId, div.focusDivId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(focusDivId);
	}

	@Override
	public String toString() {
		return "FocusDivision [focusDivId=" + focusDivId + ", focusDivisionName=" + focusDivisionName + ", users="
				+ users + "]";
	}

}
