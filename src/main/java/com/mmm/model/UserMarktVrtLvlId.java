package com.mmm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserMarktVrtLvlId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "USER_PIN")
	private String userPin;

	@Column(name = "FOCUS_MRKT_VRT_LVL1_ID")
	private Long focusMrktVrtLvl1Id;
	
	@Column(name = "FOCUS_MRKT_VRT_LVL2_ID")
	private Long focusMrktVrtLvl2Id;

	public UserMarktVrtLvlId() {
		super();
	}

	public UserMarktVrtLvlId(String userPin, Long focusMrktVrtLvl1Id, Long focusMrktVrtLvl2Id) {
		super();
		this.userPin = userPin;
		this.focusMrktVrtLvl1Id = focusMrktVrtLvl1Id;
		this.focusMrktVrtLvl2Id = focusMrktVrtLvl2Id;
	}

	public String getUserPin() {
		return userPin;
	}

	public void setUserPin(String userPin) {
		this.userPin = userPin;
	}

	public Long getFocusMrktVrtLvl1Id() {
		return focusMrktVrtLvl1Id;
	}

	public void setFocusMrktVrtLvl1Id(Long focusMrktVrtLvl1Id) {
		this.focusMrktVrtLvl1Id = focusMrktVrtLvl1Id;
	}

	public Long getFocusMrktVrtLvl2Id() {
		return focusMrktVrtLvl2Id;
	}

	public void setFocusMrktVrtLvl2Id(Long focusMrktVrtLvl2Id) {
		this.focusMrktVrtLvl2Id = focusMrktVrtLvl2Id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((focusMrktVrtLvl1Id == null) ? 0 : focusMrktVrtLvl1Id.hashCode());
		result = prime * result + ((focusMrktVrtLvl2Id == null) ? 0 : focusMrktVrtLvl2Id.hashCode());
		result = prime * result + ((userPin == null) ? 0 : userPin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMarktVrtLvlId other = (UserMarktVrtLvlId) obj;
		if (focusMrktVrtLvl1Id == null) {
			if (other.focusMrktVrtLvl1Id != null)
				return false;
		} else if (!focusMrktVrtLvl1Id.equals(other.focusMrktVrtLvl1Id))
			return false;
		if (focusMrktVrtLvl2Id == null) {
			if (other.focusMrktVrtLvl2Id != null)
				return false;
		} else if (!focusMrktVrtLvl2Id.equals(other.focusMrktVrtLvl2Id))
			return false;
		if (userPin == null) {
			if (other.userPin != null)
				return false;
		} else if (!userPin.equals(other.userPin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserMarktVrtLvlId [userPin=" + userPin + ", focusMrktVrtLvl1Id=" + focusMrktVrtLvl1Id
				+ ", focusMrktVrtLvl2Id=" + focusMrktVrtLvl2Id + "]";
	}

}