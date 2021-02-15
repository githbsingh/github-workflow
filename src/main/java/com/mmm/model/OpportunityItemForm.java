package com.mmm.model;

public class OpportunityItemForm {
	
	private String userId;
	private String userEmail;
	private String optyId;
	private String optyHyperlink;
	private String optyName;
	private String usdOptyAmount;
	private String division;
	private int feedback;
	
	public OpportunityItemForm(){
		
	}
	public OpportunityItemForm(String userId,String userEmail,String optyId,
			String optyHyperlink,String optyName,String usdOptyAmount,String division,int feedback){
		super();
		this.userId=userId;
		this.userEmail=userEmail;
		this.optyId=optyId;
		this.optyHyperlink=optyHyperlink;
		this.optyName=optyName;
		this.usdOptyAmount =usdOptyAmount;
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
	public String getOptyId() {
		return optyId;
	}
	public void setOptyId(String optyId) {
		this.optyId = optyId;
	}
	public String getOptyHyperlink() {
		return optyHyperlink;
	}
	public void setOptyHyperlink(String optyHyperlink) {
		this.optyHyperlink = optyHyperlink;
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
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public int getFeedback() {
		return feedback;
	}
	public int setFeedback(int feedback) {
		return this.feedback = feedback;
	}
}
