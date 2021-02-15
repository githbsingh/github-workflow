// Generated with g9.

package com.mmm.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "t_asgnd_user_prft_ctr")
public class UserProfitCenter implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Primary key. */
	protected static final String PK = "UserProfitCenterPkTAsgnd8D8565825D0Ce479";
	
	@EmbeddedId
	private UserPrftCtrId id;

	@ManyToOne(optional = false)
	@MapsId("focusProfitCenterId")
	private FocusProfitCenter focusProfitCenter;

	@ManyToOne(optional = false)
	@MapsId("userPin")
	private UserProfile userProfile;

	/** Default constructor. */
	public UserProfitCenter() {
		super();
	}

	public UserProfitCenter(UserPrftCtrId id) {
		super();
		this.id = id;
	}

	public UserPrftCtrId getId() {
		return id;
	}

	public void setId(UserPrftCtrId id) {
		this.id = id;
	}

	public FocusProfitCenter getFocusProfitCenter() {
		return focusProfitCenter;
	}

	public void setFocusProfitCenter(FocusProfitCenter focusProfitCenter) {
		this.focusProfitCenter = focusProfitCenter;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		UserProfitCenter other = (UserProfitCenter) obj;
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

	@Override
	public String toString() {
		return "UserProfitCenter [id=" + id + ", focusProfitCenter=" + focusProfitCenter + ", userProfile="
				+ userProfile + "]";
	}
	
}
