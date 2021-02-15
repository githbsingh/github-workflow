package com.mmm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmm.model.FocusGSC;
import com.mmm.model.UserGSC;
import com.mmm.repository.FocusGscRepository;
import com.mmm.repository.UserGSCRepository;
import com.mmm.repository.UserGscCodeRepository;

@Service
public class FocusGscService {

	@Autowired
	private FocusGscRepository focusGscRepository;

	@Autowired
	private UserGSCRepository userGscRepository;
	
	@Autowired
	private UserGscCodeRepository userGscCodeRepository;

	public List<FocusGSC> getUserGscCode(String id, long focusPrftCtrId) {
		return focusGscRepository.findByUserGscUserProfileUserPinAndFocusProfitCenter_FocusPrftCtrId(id,
				focusPrftCtrId);
	}

	public void updateUserGscCode(UserGSC userGSCObj) {
		userGscRepository.save(userGSCObj);
	}

	public void deleteUserGscCode(UserGSC userGSCObj) {
		userGscRepository.delete(userGSCObj);
	}

	public void deleteAllUserGsc(String userPin, Long userPrftCtrId) {
		userGscCodeRepository.deleteWithQuery(userPin,userPrftCtrId);		
	}

}
