// Generated with g9.

package com.mmm.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity(name = "t_asgnd_user_gsc")
public class UserGSC implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Primary key. */
	protected static final String PK = "UserGSCPkTAsgnd4D26B9887Eaff5Cb";

	@EmbeddedId
	private UserGSCId id;

	@ManyToOne(optional = false)
	@MapsId("focusGscId")
	private FocusGSC focusGsc;

	@ManyToOne(optional = false)
	@MapsId("userPin")
	private UserProfile userProfile;

	@ManyToOne(optional = false)
	@MapsId("focusProfitCenterId")
	private FocusProfitCenter focusProfitCenter;

	/** Default constructor. */
	public UserGSC() {
		super();
	}

	public UserGSC(UserGSCId id, FocusGSC focusGsc, UserProfile userProfile, FocusProfitCenter focusProfitCenter) {
		super();
		this.id = id;
		this.focusGsc = focusGsc;
		this.userProfile = userProfile;
		this.focusProfitCenter = focusProfitCenter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((focusGsc == null) ? 0 : focusGsc.hashCode());
		result = prime * result + ((focusProfitCenter == null) ? 0 : focusProfitCenter.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((userProfile == null) ? 0 : userProfile.hashCode());
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
		UserGSC other = (UserGSC) obj;
		if (focusGsc == null) {
			if (other.focusGsc != null)
				return false;
		} else if (!focusGsc.equals(other.focusGsc))
			return false;
		if (focusProfitCenter == null) {
			if (other.focusProfitCenter != null)
				return false;
		} else if (!focusProfitCenter.equals(other.focusProfitCenter))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (userProfile == null) {
			if (other.userProfile != null)
				return false;
		} else if (!userProfile.equals(other.userProfile))
			return false;
		return true;
	}

	public UserGSCId getId() {
		return id;
	}

	public void setId(UserGSCId id) {
		this.id = id;
	}

	public FocusGSC getFocusGsc() {
		return focusGsc;
	}

	public void setFocusGsc(FocusGSC focusGsc) {
		this.focusGsc = focusGsc;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public FocusProfitCenter getFocusProfitCenter() {
		return focusProfitCenter;
	}

	public void setFocusProfitCenter(FocusProfitCenter focusProfitCenter) {
		this.focusProfitCenter = focusProfitCenter;
	}

	@Override
	public String toString() {
		return "UserGSC [id=" + id + ", focusGsc=" + focusGsc + ", userProfile=" + userProfile + ", focusProfitCenter="
				+ focusProfitCenter + "]";
	}

}
