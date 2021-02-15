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
@Table(name = "t_focus_account")
public class FocusAccount {
	
	public FocusAccount() {
	}

	public FocusAccount(long focusAccId) {
		super();
		this.focusAccId = focusAccId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FOCUS_ACC_ID")
	@NaturalId
	private long focusAccId;
	
	@Column(name = "FOCUS_DIV_NAME")
	private String focusAccountName;
	
	@ManyToMany(fetch = FetchType.LAZY,mappedBy = "asgnd_accs")
	@JsonIgnore
	Set<UserProfile> users = new HashSet<UserProfile>();
	
	public long getFocusAccId() {
		return focusAccId;
	}
	public void setFocusAccId(long focusAccId) {
		this.focusAccId = focusAccId;
	}
	public String getFocusAccountName() {
		return focusAccountName;
	}
	public void setFocusAccountName(String focusAccountName) {
		this.focusAccountName = focusAccountName;
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
		FocusAccount acc = (FocusAccount) o;
		return Objects.equals(focusAccId, acc.focusAccId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(focusAccId);
	}

	@Override
	public String toString() {
		return "FocusAccount [focusAccId=" + focusAccId + ", focusAccountName=" + focusAccountName + ", users=" + users
				+ "]";
	}

}
