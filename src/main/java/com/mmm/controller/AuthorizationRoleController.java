package com.mmm.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mmm.service.AuthorizationRoleService;


@Controller
public class AuthorizationRoleController {
	
	@Autowired
	private AuthorizationRoleService authorizationRoleService;
	
	Logger logger = LoggerFactory.getLogger(AuthorizationRoleController.class);
	
	/*@RequestMapping(value = "/")
	public String  groupValidation(@RequestHeader(value = "GROUPLIST",defaultValue = "")
	String groups, @RequestHeader(value = "USERNAME",defaultValue = "" ) String userName) {
		
		logger.info("USERNAME "+userName + "GROUPLIST" + groups);
		String userPin = authorizationRoleService.userValidation(groups, userName);
	
		if(userPin != null) 
			return "redirect:/home";
		else
			return "error";
	
	}*/

}
