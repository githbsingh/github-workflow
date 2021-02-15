package com.mmm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mmm.model.FocusMarketVerticalLevel2;

public interface FocusMarketVerticalLevel2Repository extends CrudRepository<FocusMarketVerticalLevel2, Long> {

	public List<FocusMarketVerticalLevel2> findByfocusMarketVerticalLevel1_focusMrktVrtLvl1Id(long focusMrktVrtLvl1Id);

	public List<FocusMarketVerticalLevel2> findByUserMarketVerticalLevel_userProfileUserPinAndFocusMarketVerticalLevel1_FocusMrktVrtLvl1Id(
			String id, long focusMrktVrtLvl1Id);

	/* public List<FocusMarketVerticalLevel2> findByUsersUserPin(String id); */

}
