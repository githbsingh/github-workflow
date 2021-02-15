package com.mmm.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.mmm.model.FocusMarketVerticalLevel1;

public interface FocusMarketVerticalLevel1Repository extends CrudRepository<FocusMarketVerticalLevel1, Long> {

	Set<FocusMarketVerticalLevel1> findByUserMarketVerticalLevel_UserProfileUserPin (String id); 
	
}
