
package com.mmm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PROD_APP_RECOM")
public class ProdApplication {
	
	ProdApplication(){
		
	}
	
	public ProdApplication( long id){
    	super();
		this.id=id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "PROD_APPL_LINK")
	private String prodApplLink;
	
	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "USER_EMAIL")
	private String userEmail;

	@Column(name = "PROD_APPL_ID")
	private String applicationId;

	@Column(name = "SUBJ_DS", columnDefinition = "nvarchar(255)")
	private String applicationName;
	
	@Column(name = "RLTD_WON_OPTY_AT")
	private String optyAmount;
	
	@Column(name="DIV_NM")
	private String division;
	
	@Column(name = "FEEDBACK", columnDefinition = "INT DEFAULT -1")
	private int feedback;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="FEEDBACK_SENT_DATE")
	private Date sentDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProdApplLink() {
		return prodApplLink;
	}

	public void setProdApplLink(String prodApplLink) {
		this.prodApplLink = prodApplLink;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getOptyAmount() {
		return optyAmount;
	}

	public void setOptyAmount(String optyAmount) {
		this.optyAmount = optyAmount;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public int getFeedback() {
		return feedback;
	}

	public void setFeedback(int feedback) {
		this.feedback = feedback;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}


}
