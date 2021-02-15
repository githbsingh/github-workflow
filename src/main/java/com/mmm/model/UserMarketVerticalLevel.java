package com.mmm.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "UserMarketVerticalLevel")
@Table(name = "t_asgnd_user_market_vertical")
public class UserMarketVerticalLevel implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserMarktVrtLvlId id;

	@ManyToOne(optional = false)
	@MapsId("userPin")
	private UserProfile userProfile;

	@ManyToOne(optional = false)
	@MapsId("focusMrktVrtLvl1Id")
	private FocusMarketVerticalLevel1 focusMarketVerticalLevel1;

	@ManyToOne(optional = false)
	@MapsId("focusMrktVrtLvl2Id")
	private FocusMarketVerticalLevel2 focusMarketVerticalLevel2;

	public UserMarketVerticalLevel() {
		super();
	}
	
	public UserMarketVerticalLevel(UserMarktVrtLvlId id, UserProfile userProfile,
			FocusMarketVerticalLevel1 focusMarketVerticalLevel1, FocusMarketVerticalLevel2 focusMarketVerticalLevel2) {
		super();
		this.id = id;
		this.userProfile = userProfile;
		this.focusMarketVerticalLevel1 = focusMarketVerticalLevel1;
		this.focusMarketVerticalLevel2 = focusMarketVerticalLevel2;
	}

	public UserMarktVrtLvlId getId() {
		return id;
	}

	public void setId(UserMarktVrtLvlId id) {
		this.id = id;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public FocusMarketVerticalLevel1 getFocusMarketVerticalLevel1() {
		return focusMarketVerticalLevel1;
	}

	public void setFocusMarketVerticalLevel1(FocusMarketVerticalLevel1 focusMarketVerticalLevel1) {
		this.focusMarketVerticalLevel1 = focusMarketVerticalLevel1;
	}

    /*
     * @Override public boolean equals(Object o) { if (this == o) return true;
     * 
     * if (o == null || getClass() != o.getClass()) return false;
     * 
     * UserMarketVerticalLevel that = (UserMarketVerticalLevel) o; return
     * Objects.equals(userProfile, that.userProfile) &&
     * Objects.equals(focusMarketVerticalLevel1, that.focusMarketVerticalLevel1) &&
     * Objects.equals(focusMarketVerticalLevel2, that.focusMarketVerticalLevel2); }
     * 
     * @Override public int hashCode() { return Objects.hash(userProfile,
     * focusMarketVerticalLevel1, focusMarketVerticalLevel2); }
     */

	public FocusMarketVerticalLevel2 getFocusMarketVerticalLevel2() {
		return focusMarketVerticalLevel2;
	}

	public void setFocusMarketVerticalLevel2(FocusMarketVerticalLevel2 focusMarketVerticalLevel2) {
		this.focusMarketVerticalLevel2 = focusMarketVerticalLevel2;
	}

	@Override
	public String toString() {
		return "UserMarketVerticalLevel [id=" + id + ", userProfile=" + userProfile + ", focusMarketVerticalLevel1="
				+ focusMarketVerticalLevel1 + ", focusMarketVerticalLevel2=" + focusMarketVerticalLevel2 + "]";
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((focusMarketVerticalLevel1 == null) ? 0 : focusMarketVerticalLevel1.hashCode());
	    result = prime * result + ((focusMarketVerticalLevel2 == null) ? 0 : focusMarketVerticalLevel2.hashCode());
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
	    UserMarketVerticalLevel other = (UserMarketVerticalLevel) obj;
	    if (focusMarketVerticalLevel1 == null) {
		if (other.focusMarketVerticalLevel1 != null)
		    return false;
	    } else if (!focusMarketVerticalLevel1.equals(other.focusMarketVerticalLevel1))
		return false;
	    if (focusMarketVerticalLevel2 == null) {
		if (other.focusMarketVerticalLevel2 != null)
		    return false;
	    } else if (!focusMarketVerticalLevel2.equals(other.focusMarketVerticalLevel2))
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

}
