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
@Table(name="APPL_PROFILE_PPT_RECOM")
public class ApplicationProfile {
	
	ApplicationProfile(){
		
	}
	
	public ApplicationProfile( long index){
    	super();
		this.index=index;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID" ,unique = true, nullable = false)
	private long index;
	
	@Column(name = "PPT_FULLPATH", length = 400)
	private String pptFullpath;
	
	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "USER_EMAIL")
	private String userEmail;

	@Column(name = "PPTID")
	private long applicationId;

	/*@Column(name = "APPLICATION_DETAILS")
	private String applicationDetails;

	@Column(name = "PRODUCT_DESCRIPTION")
	private String productDescription;
	
	@Column(name="MARKET")
	private String market;*/
	
	@Column(name = "EMAIL_HEADER", columnDefinition = "nvarchar(255)")
	private String emailHeader;
	
	@Column(name = "SALES_AMOUNT")
	private String salesAmount;
	
	@Column(name="PL_DV_NM")
	private String division;
	
	@Column(name = "FEEDBACK", columnDefinition = "INT DEFAULT -1")
	private int feedback;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="FEEDBACK_SENT_DATE")
	private Date sentDate;

	public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index;
	}

	public String getPptFullpath() {
		return pptFullpath;
	}

	public void setPptFullpath(String pptFullpath) {
		this.pptFullpath = pptFullpath;
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

	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public String getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(String salesAmount) {
		this.salesAmount = salesAmount;
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

	public String getEmailHeader() {
		return emailHeader;
	}

	public void setEmailHeader(String emailHeader) {
		this.emailHeader = emailHeader;
	}

}
