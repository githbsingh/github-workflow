// Generated with g9.

package com.mmm.model;

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
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "t_focus_gsc", indexes = {
		@Index(name = "t_focus_gsc_focus_gsc_id_IX", columnList = "focus_gsc_id", unique = true) })
public class FocusGSC{


	/** Primary key. */
	protected static final String PK = "FocusGSCPkTFocus587Cfc727631Cd34";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "focus_gsc_id", unique = true, nullable = false, precision = 19)
	private long focusGscId;
	
	@Column(name = "focus_gsc_name", nullable = false, length = 255)
	private String focusGscName;
	
	@Column(name = "focus_gsc_code", nullable = false, length = 255)
	private String focusGscCode;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "focus_prft_ctr_id", nullable = false)
	@JsonIgnore
	private FocusProfitCenter focusProfitCenter;

	@OneToMany(mappedBy = "focusGsc", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<UserGSC> userGsc;

	/** Default constructor. */
	public FocusGSC() {
		super();
	}
	
	/**
	 * @param focusGscId
	 */
	public FocusGSC(long focusGscId) {
		super();
		this.focusGscId = focusGscId;
	}

	/**
	 * Access method for focusGscId.
	 *
	 * @return the current value of focusGscId
	 */
	public long getFocusGscId() {
		return focusGscId;
	}

	/**
	 * Setter method for focusGscId.
	 *
	 * @param aFocusGscId the new value for focusGscId
	 */
	public void setFocusGscId(long aFocusGscId) {
		focusGscId = aFocusGscId;
	}

	/**
	 * Access method for focusGscName.
	 *
	 * @return the current value of focusGscName
	 */
	public String getFocusGscName() {
		return focusGscName;
	}

	/**
	 * Setter method for focusGscName.
	 *
	 * @param aFocusGscName the new value for focusGscName
	 */
	public void setFocusGscName(String aFocusGscName) {
		focusGscName = aFocusGscName;
	}

	/**
	 * Access method for focusGscCode.
	 *
	 * @return the current value of focusGscCode
	 */
	public String getFocusGscCode() {
		return focusGscCode;
	}

	/**
	 * Setter method for focusGscCode.
	 *
	 * @param aFocusGscCode the new value for focusGscCode
	 */
	public void setFocusGscCode(String aFocusGscCode) {
		focusGscCode = aFocusGscCode;
	}

	/**
	 * Access method for focusProfitCenter.
	 *
	 * @return the current value of focusProfitCenter
	 */
	public FocusProfitCenter getFocusProfitCenter() {
		return focusProfitCenter;
	}

	/**
	 * Setter method for focusProfitCenter.
	 *
	 * @param aFocusProfitCenter the new value for focusProfitCenter
	 */
	public void setFocusProfitCenter(FocusProfitCenter aFocusProfitCenter) {
		focusProfitCenter = aFocusProfitCenter;
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
	 * Temporary value holder for group key fragment focusProfitCenterFocusPrftCtrId
	 */
	private transient long tempFocusProfitCenterFocusPrftCtrId;

	/**
	 * Gets the key fragment focusPrftCtrId for member focusProfitCenter. If
	 * this.focusProfitCenter is null, a temporary stored value for the key fragment
	 * will be returned. The temporary value is set by
	 * setFocusProfitCenterFocusPrftCtrId. This behavior is required by some
	 * persistence libraries to allow fetching of objects in arbitrary order.
	 *
	 * @return Current (or temporary) value of the key fragment
	 * @see FocusProfitCenter
	 */
	public long getFocusProfitCenterFocusPrftCtrId() {
		return (getFocusProfitCenter() == null ? tempFocusProfitCenterFocusPrftCtrId
				: getFocusProfitCenter().getFocusPrftCtrId());
	}

	/**
	 * Sets the key fragment focusPrftCtrId from member focusProfitCenter. If
	 * this.focusProfitCenter is null, the passed value will be temporary stored,
	 * and returned by subsequent calls to getFocusProfitCenterFocusPrftCtrId. This
	 * behaviour is required by some persistence libraries to allow fetching of
	 * objects in arbitrary order.
	 *
	 * @param aFocusPrftCtrId New value for the key fragment
	 * @see FocusProfitCenter
	 */
	public void setFocusProfitCenterFocusPrftCtrId(long aFocusPrftCtrId) {
		if (getFocusProfitCenter() == null) {
			tempFocusProfitCenterFocusPrftCtrId = aFocusPrftCtrId;
		} else {
			getFocusProfitCenter().setFocusPrftCtrId(aFocusPrftCtrId);
		}
	}

	/**
	 * Compares the key for this instance with another FocusGSC.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class FocusGSC and the key
	 *         objects are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FocusGSC)) {
			return false;
		}
		FocusGSC that = (FocusGSC) other;
		Object myFocusGscName = this.getFocusGscName();
		Object yourFocusGscName = that.getFocusGscName();
		if (myFocusGscName == null ? yourFocusGscName != null : !myFocusGscName.equals(yourFocusGscName)) {
			return false;
		}
		if (this.getFocusProfitCenterFocusPrftCtrId() != that.getFocusProfitCenterFocusPrftCtrId()) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another FocusGSC.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof FocusGSC))
			return false;
		return this.equalKeys(other) && ((FocusGSC) other).equalKeys(this);
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
		if (getFocusGscName() == null) {
			i = 0;
		} else {
			i = getFocusGscName().hashCode();
		}
		result = 37 * result + i;
		i = (int) (getFocusProfitCenterFocusPrftCtrId() ^ (getFocusProfitCenterFocusPrftCtrId() >>> 32));
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
		StringBuffer sb = new StringBuffer("[FocusGSC |");
		sb.append(" focusGscName=").append(getFocusGscName());
		sb.append(" focusProfitCenterFocusPrftCtrId=").append(getFocusProfitCenterFocusPrftCtrId());
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
		ret.put("focusGscName", getFocusGscName());
		ret.put("focusProfitCenterFocusPrftCtrId", Long.valueOf(getFocusProfitCenterFocusPrftCtrId()));
		return ret;
	}

}
