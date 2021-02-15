package com.mmm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mmm.model.FocusProfitCenter;

public interface FocusProfitCenterRepository extends CrudRepository<FocusProfitCenter, Long> {

	public List<FocusProfitCenter> findByUserProfitCenter_UserProfileUserPin(String userPin);
}
