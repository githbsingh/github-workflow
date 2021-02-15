package com.mmm.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmm.model.ApplicationProfile;
import com.mmm.model.ApplicationProfileForm;
import com.mmm.model.OpportunityItem;
import com.mmm.model.OpportunityItemForm;
import com.mmm.model.ProdApplication;
import com.mmm.model.ProdApplicationForm;
import com.mmm.repository.ApplicationProfileRepository;
import com.mmm.repository.OpportunityItemRepository;
import com.mmm.repository.ProdApplicationRepository;

@Service
public class EmailTemplateService {

	@Autowired
	private OpportunityItemRepository opportunityItemRepository;
	
	@Autowired
	private ApplicationProfileRepository applicationProfileRepository;
	
	@Autowired
	private ProdApplicationRepository prodApplicationRepository;
	int flag=0; 
	
	Logger logger=LoggerFactory.getLogger(EmailTemplateService.class);
	
	public List<OpportunityItem> getOpportunityItems(String userId,String sentDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(sentDate);
            return opportunityItemRepository.findTop5OpportunityItemByUserIdAndSentDateAndFeedbackOrderByUserId(userId,date,-2);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ArrayList<OpportunityItem>();
   }
	
	public List<ApplicationProfile> getApplicationProfiles(String userId,String sentDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(sentDate);
            return applicationProfileRepository.findTop5ApplicationProfileByUserIdAndSentDateAndFeedbackOrderByUserId(userId,date,-2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ArrayList<ApplicationProfile>();
   }
	
	public List<ProdApplication> getProdApplications(String userId, String sentDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(sentDate);
            System.out.print("prod appli service");
            return prodApplicationRepository.findTop5ProdApplicationByUserIdAndSentDateAndFeedbackOrderByUserId(userId, date, -2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ArrayList<ProdApplication>();
	}
	
	
	 public String updateOpportunityItemFeedback(List<OpportunityItemForm> OpportunityItemFormList ){
		 for(OpportunityItemForm opportunityItemForm :OpportunityItemFormList) {
			 flag= opportunityItemRepository.updateOpportunityItemFeedback(opportunityItemForm.getUserId(), opportunityItemForm.getOptyId(), opportunityItemForm.getFeedback());
			 logger.info("flag"+flag);
			 if(flag==0)
				 return "Sorry! There are some issues in saving your response.Please try again later.";
		  }
		
		   return "Your response has been saved successfully.Thank you!"; 
	 }
	 
	 public String updateApplicationProfileFeedback(List<ApplicationProfileForm> applicationProfileFormList ){
		 for(ApplicationProfileForm applicationProfileForm : applicationProfileFormList) {
			 flag= applicationProfileRepository.updateApplicationProfileFeedback(applicationProfileForm.getUserId(), applicationProfileForm.getApplId(), applicationProfileForm.getFeedback());
			 logger.info("flag"+flag);
			 if(flag==0)
				 return "Sorry! There are some issues in saving your response.Please try again later.";
		  }
		   return "Your response has been saved successfully.Thank you!"; 
	 }
	 
	 public String updateProdApplicationFeedback(List<ProdApplicationForm> prodApplicationFormList ){
		 for(ProdApplicationForm prodApplicationForm : prodApplicationFormList) {
			 flag= prodApplicationRepository.updateProdApplicationFeedback(prodApplicationForm.getUserId(), prodApplicationForm.getApplId(), prodApplicationForm.getFeedback());
			 logger.info("flag"+flag);
			 if(flag==0)
				 return "Sorry! There are some issues in saving your response.Please try again later.";
		  }
		   return "Your response has been saved successfully.Thank you!"; 
	 }
	 
	
	
}
