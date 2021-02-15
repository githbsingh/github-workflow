package com.mmm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mmm.model.FocusGSC;

public interface FocusGscRepository extends CrudRepository<FocusGSC, Long> {

	public List<FocusGSC> findByFocusProfitCenter_FocusPrftCtrId(long focusPrftCtrId);
	
	public List<FocusGSC> findByUserGscUserProfileUserPinAndFocusProfitCenter_FocusPrftCtrId(String userPin,long focusPrftCtrId);
}
