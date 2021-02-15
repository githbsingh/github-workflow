package com.mmm.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmm.model.FocusMarketVerticalLevel2;
import com.mmm.repository.FocusMarketVerticalLevel2Repository;

@Service
public class FocusMarketVericalLevel2Service {

	@Autowired
	private FocusMarketVerticalLevel2Repository focusMarketVerticalLevel2Repo;

	public List<FocusMarketVerticalLevel2> getUserFocusMarketVerticalLevel2(String id, long focusMrktVrtLvl1Id) {
		List<FocusMarketVerticalLevel2> userMrktVrtLvl2List = new LinkedList<FocusMarketVerticalLevel2>();
		focusMarketVerticalLevel2Repo
				.findByUserMarketVerticalLevel_userProfileUserPinAndFocusMarketVerticalLevel1_FocusMrktVrtLvl1Id(id,
						focusMrktVrtLvl1Id)
				.forEach(userMrktVrtLvl2List::add);
		return userMrktVrtLvl2List;
	}

}
