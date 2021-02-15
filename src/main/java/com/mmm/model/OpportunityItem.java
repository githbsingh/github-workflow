package com.mmm.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




//RD_APP_INOUT_DB
@Entity
@Table(name = "OPTY_RECOM")
public class OpportunityItem {
	
	public OpportunityItem(){
		
	}
    public OpportunityItem( long id){
    	super();
		this.id=id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	@Column(name = "OPTY_HYPERLINK")
	private String optyHyperlink;
	
	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "USER_EMAIL")
	private String userEmail;

	@Column(name = "OPTY_ID")
	private String optyId;

	@Column(name = "OPTY_NM", columnDefinition = "nvarchar(255)")
	private String optyName;

	@Column(name = "USD_OPTY_AT")
	private String usdOptyAmount;
	
	@Column(name="DIVISION")
	private String division;
	
	@Column(name = "FEEDBACK", columnDefinition = "INT DEFAULT -1")
	private int feedback;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="FEEDBACK_SENT_DATE")
	private Date sentDate;
	
	/*
	 	
	@Column(name="MARKET_SEGMENT")
	private String marketSegment;
	
	@Column(name="BATCH_NO")
	private String batchNo;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="CREATED_DT")
	private Date createdDate;
	
	@Column(name = "OPTY_TYPE_DS")
	private String optyTypeDescription;
	
	@Column(name = "SLS_CHNL_ID")
	private String slsChnlId;
	
	@Column(name="RANK")
	private long rank;
	
	@Column(name="SENT_FLAG")
	private long sentFlag;
	
	@Column(name="FILTER_FLAG")
	private long filterFlag;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="FEEDBACK_RECEIVED_DATE")
	private Date receivedDate;*/
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOptyHyperlink() {
		return optyHyperlink;
	}
	public void setOptyHyperlink(String optyHyperlink) {
		this.optyHyperlink = optyHyperlink;
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
	public String getOptyId() {
		return optyId;
	}
	public void setOptyId(String optyId) {
		this.optyId = optyId;
	}
	public String getOptyName() {
		return optyName;
	}
	public void setOptyName(String optyName) {
		this.optyName = optyName;
	}
	public String getUsdOptyAmount() {
		return usdOptyAmount;
	}
	public void setUsdOptyAmount(String usdOptyAmount) {
		this.usdOptyAmount = usdOptyAmount;
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
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		OpportunityItem opty = (OpportunityItem) o;
		return Objects.equals(id, opty.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	


}
