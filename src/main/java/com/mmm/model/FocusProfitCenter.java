// Generated with g9.

package com.mmm.model;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "t_focus_profit_center")
public class FocusProfitCenter {

	/** Primary key. */
	protected static final String PK = "focusPrftCtrId";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "focus_prft_ctr_id", unique = true, nullable = false, precision = 19)
	private long focusPrftCtrId;

	@Column(name = "focus_prft_ctr_name", length = 255)
	private String focusPrftCtrName;

	@Column(name = "focus_prft_ctr_code", length = 255)
	private String focusPrftCtrCode;
	
	@OneToMany(mappedBy = "focusProfitCenter", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<FocusGSC> focusGsc = new HashSet<FocusGSC>();

	@OneToMany(mappedBy = "focusProfitCenter", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<UserProfitCenter> userProfitCenter = new HashSet<UserProfitCenter>();

	@OneToMany(mappedBy = "focusProfitCenter", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<UserGSC> userGsc = new HashSet<UserGSC>();
	 

	/** Default constructor. */
	public FocusProfitCenter() {
		super();
	}

	public FocusProfitCenter(long focusPrftCtrId) {
		super();
		this.focusPrftCtrId = focusPrftCtrId;
	}

	/**
	 * Access method for focusPrftCtrId.
	 *
	 * @return the current value of focusPrftCtrId
	 */
	public long getFocusPrftCtrId() {
		return focusPrftCtrId;
	}

	/**
	 * Setter method for focusPrftCtrId.
	 *
	 * @param aFocusPrftCtrId the new value for focusPrftCtrId
	 */
	public void setFocusPrftCtrId(long aFocusPrftCtrId) {
		focusPrftCtrId = aFocusPrftCtrId;
	}

	/**
	 * Access method for focusPrftCtrName.
	 *
	 * @return the current value of focusPrftCtrName
	 */
	public String getFocusPrftCtrName() {
		return focusPrftCtrName;
	}

	/**
	 * Setter method for focusPrftCtrName.
	 *
	 * @param aFocusPrftCtrName the new value for focusPrftCtrName
	 */
	public void setFocusPrftCtrName(String aFocusPrftCtrName) {
		focusPrftCtrName = aFocusPrftCtrName;
	}

	/**
	 * Access method for focusPrftCtrCode.
	 *
	 * @return the current value of focusPrftCtrCode
	 */
	public String getFocusPrftCtrCode() {
		return focusPrftCtrCode;
	}

	/**
	 * Setter method for focusPrftCtrCode.
	 *
	 * @param aFocusPrftCtrCode the new value for focusPrftCtrCode
	 */
	public void setFocusPrftCtrCode(String aFocusPrftCtrCode) {
		focusPrftCtrCode = aFocusPrftCtrCode;
	}

	/**
	 * Access method for focusGsc.
	 *
	 * @return the current value of focusGsc
	 */

	public Set<FocusGSC> getFocusGsc() {
		return focusGsc;
	}

	/**
	 * Setter method for focusGsc.
	 *
	 * @param aFocusGsc the new value for focusGsc
	 */
	public void setFocusGsc(Set<FocusGSC> aFocusGsc) {
		focusGsc = aFocusGsc;
	}

	/**
	 * Access method for userProfitCenter.
	 *
	 * @return the current value of userProfitCenter
	 */

	public Set<UserProfitCenter> getUserProfitCenter() {
		return userProfitCenter;
	}

	/**
	 * Setter method for userProfitCenter.
	 *
	 * @param aUserProfitCenter the new value for userProfitCenter
	 */
	public void setUserProfitCenter(Set<UserProfitCenter> aUserProfitCenter) {
		userProfitCenter = aUserProfitCenter;
	}

	/**
	 * Access method for userGsc.
	 *
	 * @return the current value of userGsc
	 */

	public Set<UserGSC> getUserGsc() {
		return userGsc;
	}

	/**
	 * Setter method for userGsc.
	 *
	 * @param aUserGsc the new value for userGsc
	 */
	public void setUserGsc(Set<UserGSC> aUserGsc) {
		userGsc = aUserGsc;
	}

	/**
	 * Compares the key for this instance with another FocusProfitCenter.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class FocusProfitCenter and the
	 *         key objects are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FocusProfitCenter)) {
			return false;
		}
		FocusProfitCenter that = (FocusProfitCenter) other;
		if (this.getFocusPrftCtrId() != that.getFocusPrftCtrId()) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another FocusProfitCenter.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof FocusProfitCenter))
			return false;
		return this.equalKeys(other) && ((FocusProfitCenter) other).equalKeys(this);
	}

	/**
	 * Returns a hash code for this instance.
	 *
	 * @return Hash code
	 */
	@Override
	public int hashCode() {
		int i;
		int result = 17;
		i = (int) (getFocusPrftCtrId() ^ (getFocusPrftCtrId() >>> 32));
		result = 37 * result + i;
		return result;
	}

	/**
	 * Returns a debug-friendly String representation of this instance.
	 *
	 * @return String representation of this instance
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[FocusProfitCenter |");
		sb.append(" focusPrftCtrId=").append(getFocusPrftCtrId());
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Return all elements of the primary key.
	 *
	 * @return Map of key names to values
	 */
	public Map<String, Object> getPrimaryKey() {
		Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
		ret.put("focusPrftCtrId", Long.valueOf(getFocusPrftCtrId()));
		return ret;
	}


}
