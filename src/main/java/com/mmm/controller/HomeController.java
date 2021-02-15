/**
 * 
 */
package com.mmm.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mmm.model.UserProfile;
import com.mmm.model.UserProfileForm;

/**
 * @author A2KRJZZ
 *
 */
@Controller
public class HomeController {

	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class.getName());
	private static final String VSRM_SECURITY_GROUP = "PUBLIC_R&D_APPRECOM_USERPROFILEMGMT";

	@RequestMapping(value = "/")
	public String onInit(Model model, @RequestHeader(value = "GROUPLIST", defaultValue = "") String groups,
			@RequestHeader(value = "USERNAME", defaultValue = "") String userName) {

		if (LOG.isTraceEnabled()) {
			LOG.trace(">> onInit()");
		}

		String env = System.getProperty("mmm.app.env");

		if (env != null) {
			env = env.toLowerCase();
			LOG.debug("Testing security for env >> " + env + " environment");
		} else {
			throw new RuntimeException("Environment variable is not defined in the JVM!");
		}

		LOG.debug("Login user name >> " + userName);

		if (isInGroup(groups, env)) {
			model.addAttribute("userProfileInfo", new UserProfile());
			model.addAttribute("userProfileForm", new UserProfileForm());
			if (LOG.isTraceEnabled()) {
				LOG.trace("<< onInit() Navigating to Home");
			}
			return "home";
		} else {
			if (LOG.isTraceEnabled()) {
				LOG.trace("<< onInit() Navigating to Error");
			}
			return "error";
		}
	}

	public boolean isInGroup(String groupList, String env) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> isInGroup()");
		}
		boolean inGroup = false;

		if (env.equals("local")) {
			// always valid in local environment
			inGroup = true;
			LOG.debug("Local environment. No Tests Performed. User Authorized.");
		} else {
			// search for the group in the request header:
			if (groupList != null) {
				LOG.debug("Testing Security group >> " + VSRM_SECURITY_GROUP);
				List<String> activeDirectoryGroups = new ArrayList<>();
				if (StringUtils.isNotBlank(groupList)) {
					activeDirectoryGroups = Arrays.asList(groupList.split("\\^"));
					if (activeDirectoryGroups.contains(VSRM_SECURITY_GROUP)) {
						inGroup = true;
						LOG.debug("User has access to >> " + VSRM_SECURITY_GROUP);
					} else {
						inGroup = false;
						LOG.debug("User has NO access to >> " + VSRM_SECURITY_GROUP);
					}
				}
			}
		}
		if (LOG.isTraceEnabled()) {
			LOG.trace("<< isInGroup()");
		}
		return inGroup;
	}
}
