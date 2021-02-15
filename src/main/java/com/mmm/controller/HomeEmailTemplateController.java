package com.mmm.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mmm.model.ApplicationProfile;
import com.mmm.model.ApplicationProfileForm;
import com.mmm.model.ApplicationProfileFormListWrapper;
import com.mmm.model.OpportunityItem;
import com.mmm.model.OpportunityItemForm;
import com.mmm.model.OpportunityItemFormListWrapper;
import com.mmm.model.ProdApplication;
import com.mmm.model.ProdApplicationForm;
import com.mmm.model.ProdApplicationFormListWrapper;
import com.mmm.service.EmailTemplateService;

@Controller
public class HomeEmailTemplateController {
	
	@Autowired
	private EmailTemplateService emailTemplateService;
	
	Logger logger = LoggerFactory.getLogger(HomeEmailTemplateController.class);
	
	@RequestMapping(value = "/emailTemplate/opportunityItem")
	public String onInitEmailTemplateOpportunityItems(Model model,@RequestParam String userId, @RequestParam String sentDate) {
		logger.info( "BEGIN onInitEmailTemplateOpportunityItems" + userId + sentDate);

		String env = System.getProperty("mmm.app.env");
		logger.info( "Environment :" + env);
		
		List<OpportunityItem> opportunityItemList = emailTemplateService.getOpportunityItems(userId,sentDate);
		ArrayList<OpportunityItemForm> opportunityItemFormList=new ArrayList<OpportunityItemForm>();
		if(opportunityItemList.isEmpty()){
			model.addAttribute("submissionStatus","You have already submitted the response!");
		}
		else {
		opportunityItemList.forEach(optyItem->{
			OpportunityItemForm optyForm=new OpportunityItemForm();
			optyForm.setOptyId(optyItem.getOptyId());
			optyForm.setOptyName(optyItem.getOptyName());
			optyForm.setOptyHyperlink(optyItem.getOptyHyperlink());
			optyForm.setUserId(optyItem.getUserId());
			optyForm.setUsdOptyAmount(currencyConversion(optyItem.getUsdOptyAmount()));
			optyForm.setUserEmail(optyItem.getUserEmail());
			optyForm.setFeedback(optyItem.getFeedback());
			optyForm.setDivision(optyItem.getDivision());
			opportunityItemFormList.add(optyForm);
		});	
		OpportunityItemFormListWrapper wrapper= new OpportunityItemFormListWrapper();
		wrapper.setOpportunityItemFormList(opportunityItemFormList);
		model.addAttribute("wrapper",wrapper);
		if (env != null)
			model.addAttribute("applicationUrl", getApplicationUrl(env));
		else 
			throw new RuntimeException("Environment variable is not defined in the JVM!");  
		}
		logger.info("END onInitEmailTemplateOpportunityItems");
		return "opportunityItem";
	}
	
	@RequestMapping(value = "/emailTemplate/applicationProfile")
	public String onInitEmailTemplateApplicationProfile(Model model,@RequestParam String userId, @RequestParam String sentDate) {
		logger.info( "BEGIN onInitEmailTemplateApplicationProfile" + userId + sentDate);
		
		String env = System.getProperty("mmm.app.env");
		logger.info( "Environment :" + env);
		
		List<ApplicationProfile> applicationProfileList = emailTemplateService.getApplicationProfiles(userId,sentDate);
		ArrayList<ApplicationProfileForm> applicationProfileFormList=new ArrayList<ApplicationProfileForm>();
		if(applicationProfileList.isEmpty()){
			model.addAttribute("submissionStatus","You have already submitted the response!");
		}
		else {
		applicationProfileList.forEach(appProfile->{
			ApplicationProfileForm appProfileForm=new ApplicationProfileForm();
			appProfileForm.setApplId(appProfile.getApplicationId());
			appProfileForm.setApplName(appProfile.getEmailHeader());
			appProfileForm.setApplHyperLink(appProfile.getPptFullpath());
			appProfileForm.setUserId(appProfile.getUserId());
			appProfileForm.setSalesAmount(currencyConversion(appProfile.getSalesAmount()));
			appProfileForm.setUserEmail(appProfile.getUserEmail());
			appProfileForm.setFeedback(appProfile.getFeedback());
			appProfileForm.setDivision(appProfile.getDivision());
			applicationProfileFormList.add(appProfileForm);
		});	
		ApplicationProfileFormListWrapper wrapper= new ApplicationProfileFormListWrapper();
		wrapper.setApplicationProfileFormList(applicationProfileFormList);
		model.addAttribute("wrapper",wrapper);
		if (env != null)
			model.addAttribute("applicationUrl", getApplicationUrl(env));
		else 
			throw new RuntimeException("Environment variable is not defined in the JVM!");  
		}
		logger.info("END onInitEmailTemplateApplicationProfiles");
		return "applicationProfile";
	}
	
	@RequestMapping(value = "/emailTemplate/prodApplication")
	public String onInitEmailTemplateProdApplications(Model model,@RequestParam String userId, @RequestParam String sentDate) {
		logger.info( "BEGIN onInitEmailTemplateProdApplications" + userId + sentDate);
		
		String env = System.getProperty("mmm.app.env");
		logger.info( "Environment :" + env);
		
		List<ProdApplication> prodApplicationList = emailTemplateService.getProdApplications(userId, sentDate);
		ArrayList<ProdApplicationForm> prodApplicationFormList=new ArrayList<ProdApplicationForm>();
		if(prodApplicationList.isEmpty()){
			model.addAttribute("submissionStatus","You have already submitted the response!");
		}
		else {
			prodApplicationList.forEach(prodAppl->{
				ProdApplicationForm prodApplForm =new ProdApplicationForm();
				prodApplForm.setApplId(prodAppl.getApplicationId());
				prodApplForm.setApplName(prodAppl.getApplicationName());
				prodApplForm.setApplHyperLink(prodAppl.getProdApplLink());
				prodApplForm.setUserId(prodAppl.getUserId());
				prodApplForm.setOptyAmount(currencyConversion(prodAppl.getOptyAmount()));
				prodApplForm.setUserEmail(prodAppl.getUserEmail());
				prodApplForm.setFeedback(prodAppl.getFeedback());
				prodApplForm.setDivision(prodAppl.getDivision());
			prodApplicationFormList.add(prodApplForm);
		});	
	    ProdApplicationFormListWrapper wrapper= new ProdApplicationFormListWrapper();
		wrapper.setProdApplicationFormList(prodApplicationFormList);
		model.addAttribute("wrapper",wrapper);
		if (env != null)
			model.addAttribute("applicationUrl", getApplicationUrl(env));
		else 
			throw new RuntimeException("Environment variable is not defined in the JVM!");  
		}
		logger.info("END onInitEmailTemplateProdApplications");
		return "prodApplication";
	}
	String currencyConversion(String amount ) {
	  if (amount!=null)
	  {		  
	  NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
      String currency = format.format(new Double(amount));
      currency = currency.substring(0, currency.indexOf('.'));
      return currency;
	  }
	  else
	  return amount;
      
	}
	String getApplicationUrl(String env) {
		
		 if(env.equalsIgnoreCase("prod")) {
			return "https://apprecom.3m.com/appenggusermgmt/";
		}
		else if(env.equalsIgnoreCase("qa")){
			return "https://apprecom-qa.3m.com/appenggusermgmt/";	
		}
		else if(env.equalsIgnoreCase("dev")){
			return "https://apprecom-dev.mmm.com/appenggusermgmt/";
		}
		else {
			return "localhost:9092/appenggusermgmt/";
		}
		
	}
}
