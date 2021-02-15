package com.mmm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserPrftCtrId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "users_user_pin")
	private String userPin;

	@Column(name = "focus_prft_ctrs_prft_ctr_id")
	private Long focusProfitCenterId;
	
	public UserPrftCtrId() {
		super();
	}

	public UserPrftCtrId(String userPin, Long focusProfitCenterId) {
		super();
		this.userPin = userPin;
		this.focusProfitCenterId = focusProfitCenterId;
	}

	public String getUserPin() {
		return userPin;
	}

	public void setUserPin(String userPin) {
		this.userPin = userPin;
	}

	public Long getFocusProfitCenterId() {
		return focusProfitCenterId;
	}

	public void setFocusProfitCenterId(Long focusProfitCenterId) {
		this.focusProfitCenterId = focusProfitCenterId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((focusProfitCenterId == null) ? 0 : focusProfitCenterId.hashCode());
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
		UserPrftCtrId other = (UserPrftCtrId) obj;
		if (focusProfitCenterId == null) {
			if (other.focusProfitCenterId != null)
				return false;
		} else if (!focusProfitCenterId.equals(other.focusProfitCenterId))
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
		return "UserPrftCtrId [userPin=" + userPin + ", focusProfitCenterId=" + focusProfitCenterId + "]";
	}

}
