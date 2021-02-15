package com.mmm.model;

public class ProdApplicationForm {
	private String userId;
	private String userEmail;
	private String applId;
	private String applHyperLink;
	private String applName;
	private String optyAmount;
	private String division;
	private int feedback;
	
	public ProdApplicationForm(){
		
	}
	public ProdApplicationForm(String userId,String userEmail,String applId,
			String applHyperLink,String applName,String optyAmount,String division,int feedback){
		super();
		this.userId=userId;
		this.userEmail=userEmail;
		this.applId=applId;
		this.applHyperLink=applHyperLink;
		this.applName=applName;
		this.optyAmount =optyAmount;
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
	public String getApplId() {
		return applId;
	}
	public void setApplId(String applId) {
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
}
