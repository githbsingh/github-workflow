/**
 * 
 */
package com.mmm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mmm.service.UserProfileService;

/**
 * @author a2krjzz
 * Class containing methods to search users by Name or User Pin
 *
 */
@Controller
@RequestMapping("/searchUser")
public class UserProfileSearchController {

	private static final Logger LOG = LoggerFactory.getLogger(UserProfileSearchController.class.getName());
	
	@Autowired
	private UserProfileService userProfileService;

	/**
	 * Search by User pin through auto complete field.
	 * @param request
	 * @return list of user pins
	 */
	@RequestMapping(value = "/searchUserPin", method = RequestMethod.GET)
	@ResponseBody
	public List<String> searchByUserPin(HttpServletRequest request) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> searchUserPin()");
		}
		return userProfileService.searchByUserPin(request.getParameter("term"));
	}

	/**
	 * Search by user name through auto complete field.
	 * @param request
	 * @return list of user names
	 */
	@RequestMapping(value = "/searchUserName", method = RequestMethod.GET)
	@ResponseBody
	public List<String> searchByUserName(HttpServletRequest request) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> searchUserName()");
		}
		return userProfileService.searchByUserName(request.getParameter("term"));
	}

}
