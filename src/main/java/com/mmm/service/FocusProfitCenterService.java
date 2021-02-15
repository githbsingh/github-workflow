package com.mmm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmm.model.FocusProfitCenter;
import com.mmm.model.UserProfitCenter;
import com.mmm.repository.FocusProfitCenterRepository;
import com.mmm.repository.UserProfitCenterRepository;

@Service
public class FocusProfitCenterService {

	@Autowired
	private FocusProfitCenterRepository focusProfitCenterRepository;

	@Autowired
	private UserProfitCenterRepository userProfitCenterRepository;

	public List<FocusProfitCenter> getUserFocusProfitCenter(String userPin) {
		return focusProfitCenterRepository.findByUserProfitCenter_UserProfileUserPin(userPin);
	}

	public void updateUserProfitCenter(UserProfitCenter userProfitCenterObj) {
		userProfitCenterRepository.save(userProfitCenterObj);
	}

	public Optional<FocusProfitCenter> findById(Long prftCtrId) {
		return focusProfitCenterRepository.findById(prftCtrId);
	}

	public void deleteUserProfitCenter(UserProfitCenter userProfitCenterObj) {
		userProfitCenterRepository.delete(userProfitCenterObj);
	}

}
