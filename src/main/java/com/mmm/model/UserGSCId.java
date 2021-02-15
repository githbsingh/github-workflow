package com.mmm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserGSCId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "user_profile_user_pin")
	private String userPin;

	@Column(name = "focus_prft_ctrs__prft_ctr_id")
	private Long focusProfitCenterId;
	
	@Column(name = "focus_gscs_focus_gsc_id")
	private Long focusGscId;

	public UserGSCId() {
		super();
	}

	public UserGSCId(String userPin, Long focusProfitCenterId, Long focusGscId) {
		super();
		this.userPin = userPin;
		this.focusProfitCenterId = focusProfitCenterId;
		this.focusGscId = focusGscId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((focusGscId == null) ? 0 : focusGscId.hashCode());
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
		UserGSCId other = (UserGSCId) obj;
		if (focusGscId == null) {
			if (other.focusGscId != null)
				return false;
		} else if (!focusGscId.equals(other.focusGscId))
			return false;
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

	public Long getFocusGscId() {
		return focusGscId;
	}

	public void setFocusGscId(Long focusGscId) {
		this.focusGscId = focusGscId;
	}

	@Override
	public String toString() {
		return "UserGSCId [userPin=" + userPin + ", focusProfitCenterId=" + focusProfitCenterId + ", focusGscId="
				+ focusGscId + "]";
	}

}
