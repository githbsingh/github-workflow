package com.mmm.model;

public class ApplicationProfileForm {
	
	private String userId;
	private String userEmail;
	private long applId;
	private String applHyperLink;
	private String applName;
	private String salesAmount;
	private String division;
	private int feedback;
	
	public ApplicationProfileForm(){
		
	}
	public ApplicationProfileForm(String userId,String userEmail,long applId,
			String applHyperLink,String applName,String salesAmount,String division,int feedback){
		super();
		this.userId=userId;
		this.userEmail=userEmail;
		this.applId=applId;
		this.applHyperLink=applHyperLink;
		this.applName=applName;
		this.salesAmount =salesAmount;
		this.division=division;
		this.feedback=feedback;
		
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
	public long getApplId() {
		return applId;
	}
	public void setApplId(long applId) {
		this.applId = applId;
	}
	public String getApplHyperLink() {
		return applHyperLink;
	}
	public void setApplHyperLink(String applHyperLink) {
		this.applHyperLink = applHyperLink;
	}
	public String getApplName() {
		return applName;
	}
	public void setApplName(String applName) {
		this.applName = applName;
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



}
