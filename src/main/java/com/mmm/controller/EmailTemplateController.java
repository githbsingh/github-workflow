package com.mmm.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmm.model.ApplicationProfileFormListWrapper;
import com.mmm.model.OpportunityItemFormListWrapper;
import com.mmm.model.ProdApplicationFormListWrapper;
import com.mmm.service.EmailTemplateService;

@RestController
public class EmailTemplateController {
	
	@Autowired
	private EmailTemplateService emailTemplateService;
	

	
	Logger logger = LoggerFactory.getLogger(EmailTemplateController.class);
		
	/*@RequestMapping(value = "/getEmailTemplate/{userId}",method = RequestMethod.GET)
	public ResponseEntity<Object> getEmailTemplate(@PathVariable("userId") String userId) {

		 //logger.info("BEGIN getEmailTemplate");
		 //List<OpportunityItem> opportunityItemFormList = emailTemplateService.getEmailTemplate(userId);
		 //logger.info(opportunityItemFormList.get(0).getOptyId());
		// return new ResponseEntity<Object> (opportunityItemFormList, HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/emailTemplate/updateOpportunityItemFeedback",method = RequestMethod.POST)
	public ModelAndView updateOpportunityItemFeedback(@ModelAttribute OpportunityItemFormListWrapper wrapper, Model model) {
		  logger.info("BEGIN updateOpportunityItemFeedback");		 
		  String submissionStatus=emailTemplateService.updateOpportunityItemFeedback(wrapper.getOpportunityItemFormList());
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("opportunityItem");
		  modelAndView.addObject("submissionStatus", submissionStatus);
		  logger.info("END updateOpportunityItemFeedback");
		  return modelAndView;
		 
	}
	@RequestMapping(value = "/emailTemplate/updateApplProfileFeedback",method = RequestMethod.POST)
	public ModelAndView updateApplProfileFeedback(@ModelAttribute ApplicationProfileFormListWrapper wrapper, Model model) {
		  logger.info("BEGIN updateApplProfileFeedback");		 
		  String submissionStatus=emailTemplateService.updateApplicationProfileFeedback(wrapper.getApplicationProfileFormList());
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("applicationProfile");
		  modelAndView.addObject("submissionStatus", submissionStatus);
		  logger.info("END updateApplProfileFeedback");
		  return modelAndView;
		 
	}
	@RequestMapping(value = "/emailTemplate/updateProdApplicationFeedback",method = RequestMethod.POST)
	public ModelAndView updateProdApplicationFeedback(@ModelAttribute ProdApplicationFormListWrapper wrapper, Model model) {
		  logger.info("BEGIN updateFeedback");		 
		  String submissionStatus=emailTemplateService.updateProdApplicationFeedback(wrapper.getProdApplicationFormList());
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("prodApplication");
		  modelAndView.addObject("submissionStatus", submissionStatus);
		  logger.info("END updateFeedback");
		  return modelAndView;
		 
	}
	
}
