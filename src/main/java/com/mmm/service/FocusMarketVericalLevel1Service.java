package com.mmm.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmm.model.FocusMarketVerticalLevel1;
import com.mmm.repository.FocusMarketVerticalLevel1Repository;

@Service
public class FocusMarketVericalLevel1Service {

	@Autowired
	private FocusMarketVerticalLevel1Repository focusMarketVerticalLevel1Repo;

	public List<FocusMarketVerticalLevel1> getUserFocusMarketVerticalLevel1(String id) {
		List<FocusMarketVerticalLevel1> userMrktVrtLvl1List = new LinkedList<FocusMarketVerticalLevel1>();
		focusMarketVerticalLevel1Repo.findByUserMarketVerticalLevel_UserProfileUserPin(id).forEach(userMrktVrtLvl1List::add);
		return userMrktVrtLvl1List;
	}

}
