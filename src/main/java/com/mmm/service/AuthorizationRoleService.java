package com.mmm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;



@Service
public class AuthorizationRoleService {

	public String userValidation(String groups, String userName) {
		
		List<String> activeDirectoryGroups = new ArrayList<>();
		
		if(StringUtils.isNotBlank(groups)){
			activeDirectoryGroups = Arrays.asList(groups.split("\\^"));
		}
		
		if(activeDirectoryGroups.contains("PUBLIC_RESEARCHDEVELOPMENT_USERPROFILEMANAGEMENTSYSTEM"))
			return userName;
		else 
			return null;
		
	}

}
