/**
 * 
 */
package com.mmm.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author a2krjzz
 *
 */
@Entity
@Table(name = "t_user_profile")
public class UserProfile {

	public UserProfile() {
	}

	/**
	 * @param userPin
	 */
	public UserProfile(String userPin) {
		super();
		this.userPin = userPin;
	}

	@Id
	@Column(name = "USER_PIN")
	private String userPin;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "FULL_NAME")
	private String fullName;

	@Column(name = "EMAIL_ADDR")
	private String emailAddress;

	@Column(name = "JOB_DESC")
	private String jobDescription;

	@Column(name = "PRIME_DIV")
	private String primaryDivision;

	@Column(name = "PRIME_COUNTRY")
	private String primaryCountry;

	@Column(name = "USER_ROLE")
	private String userRole;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "t_asgnd_user_divisions", joinColumns = @JoinColumn(referencedColumnName = "USER_PIN"), inverseJoinColumns = @JoinColumn(referencedColumnName = "FOCUS_DIV_ID"))
	@JsonIgnore
	Set<FocusDivision> asgnd_divs = new HashSet<FocusDivision>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "t_asgnd_user_accounts", joinColumns = @JoinColumn(referencedColumnName = "USER_PIN"), inverseJoinColumns = @JoinColumn(referencedColumnName = "FOCUS_ACC_ID"))
	@JsonIgnore
	Set<FocusAccount> asgnd_accs = new HashSet<FocusAccount>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "t_asgnd_user_country", joinColumns = @JoinColumn(referencedColumnName = "USER_PIN"), inverseJoinColumns = @JoinColumn(referencedColumnName = "FOCUS_CTRY_ID"))
	@JsonIgnore
	Set<FocusCountry> asgnd_ctrys = new HashSet<FocusCountry>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "t_asgnd_user_technology", joinColumns = @JoinColumn(referencedColumnName = "USER_PIN"), inverseJoinColumns = @JoinColumn(referencedColumnName = "FOCUS_TECH_ID"))
	@JsonIgnore
	Set<FocusTechnology> asgnd_techs = new HashSet<FocusTechnology>();

	@OneToMany(mappedBy = "userProfile", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<UserMarketVerticalLevel> UserMarketVerticalLevel = new HashSet<UserMarketVerticalLevel>();

	@OneToMany(mappedBy = "userProfile", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<UserGSC> userGsc = new HashSet<UserGSC>();

	@OneToMany(mappedBy = "userProfile", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<UserProfitCenter> userProfitCenter = new HashSet<UserProfitCenter>();

	public void addDiv(FocusDivision div) {
		asgnd_divs.add(div);
		div.getUsers().add(this);
	}

	public void removeDiv(FocusDivision div) {
		asgnd_divs.remove(div);
		div.getUsers().remove(this);
	}

	public void addAcc(FocusAccount acc) {
		asgnd_accs.add(acc);
		acc.getUsers().add(this);
	}

	public void removeAcc(FocusAccount acc) {
		asgnd_accs.remove(acc);
		acc.getUsers().remove(this);
	}

	public void addCtry(FocusCountry ctry) {
		asgnd_ctrys.add(ctry);
		ctry.getUsers().add(this);
	}

	public void removeCtry(FocusCountry ctry) {
		asgnd_ctrys.remove(ctry);
		ctry.getUsers().remove(this);
	}

	public void addTech(FocusTechnology tech) {
		asgnd_techs.add(tech);
		tech.getUsers().add(this);
	}

	public void removeTech(FocusTechnology tech) {
		asgnd_techs.remove(tech);
		tech.getUsers().remove(this);
	}
	
	public String getUserPin() {
		return userPin;
	}

	public void setUserPin(String userPin) {
		this.userPin = userPin;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getPrimaryDivision() {
		return primaryDivision;
	}

	public void setPrimaryDivision(String primaryDivision) {
		this.primaryDivision = primaryDivision;
	}

	public String getPrimaryCountry() {
		return primaryCountry;
	}

	public void setPrimaryCountry(String primaryCountry) {
		this.primaryCountry = primaryCountry;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof UserProfile))
			return false;
		return userPin != null && userPin.equals(((UserProfile) o).getUserPin());
	}

	@Override
	public int hashCode() {
		return Objects.hash(userPin);
	}

	@Override
	public String toString() {
		return "UserProfile [userPin=" + userPin + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName="
				+ fullName + ", emailAddress=" + emailAddress + ", jobDescription=" + jobDescription
				+ ", primaryDivision=" + primaryDivision + ", primaryCountry=" + primaryCountry + ", userRole="
				+ userRole + "]";
	}

}
