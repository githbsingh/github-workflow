package com.mmm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmm.exception.UserNotFoundException;
import com.mmm.model.FocusAccount;
import com.mmm.model.FocusCountry;
import com.mmm.model.FocusDivision;
import com.mmm.model.FocusGSC;
import com.mmm.model.FocusMarketVerticalLevel1;
import com.mmm.model.FocusMarketVerticalLevel2;
import com.mmm.model.FocusProfitCenter;
import com.mmm.model.FocusTechnology;
import com.mmm.model.UserGSC;
import com.mmm.model.UserGSCId;
import com.mmm.model.UserMarketVerticalLevel;
import com.mmm.model.UserMarktVrtLvlId;
import com.mmm.model.UserPrftCtrId;
import com.mmm.model.UserProfile;
import com.mmm.model.UserProfileForm;
import com.mmm.model.UserProfitCenter;
import com.mmm.service.FocusAccountService;
import com.mmm.service.FocusCountryService;
import com.mmm.service.FocusDivisionService;
import com.mmm.service.FocusGscService;
import com.mmm.service.FocusMarketVericalLevel1Service;
import com.mmm.service.FocusMarketVericalLevel2Service;
import com.mmm.service.FocusProfitCenterService;
import com.mmm.service.FocusTechnologyService;
import com.mmm.service.UserMarketVerticalLevelService;
import com.mmm.service.UserProfileService;

/**
 * @author a2krjzz
 * 
 *         This class consists of update and delete methods to add or remove the
 *         attributes for a user profile.
 */
@RestController
public class UserProfileSaveController {

    private static final Logger LOG = LoggerFactory.getLogger(UserProfileSaveController.class.getName());

    @Autowired
    private FocusDivisionService focusDivisionService;

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private FocusAccountService focusAccountService;

    @Autowired
    private FocusCountryService focusCountryService;

    @Autowired
    private FocusTechnologyService focusTechnologyService;

    @Autowired
    private UserMarketVerticalLevelService userMarketVerticalLevelService;

    @Autowired
    private FocusMarketVericalLevel1Service focusMrktVrtLvl1Service;

    @Autowired
    private FocusMarketVericalLevel2Service focusMrktVrtLvl2Service;

    @Autowired
    private FocusProfitCenterService focusProfitCenterService;

    @Autowired
    private FocusGscService focusGscService;

    /**
     * @param userProfileForm
     * @return
     */
    @PostMapping("/updateUserRole")
    public ResponseEntity<String> updateUserRole(@RequestBody UserProfileForm userProfileForm) {
	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> updateUserRole()");
	}
	UserProfile userProfile = userProfileService.getUserProfile(userProfileForm.getUserPin())
		.orElseThrow(() -> new UserNotFoundException(userProfileForm.getUserPin()));
	userProfile.setUserRole(userProfileForm.getUserRole());
	userProfileService.updateUserProfile(userProfile);
	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< updateUserRole()");
	}
	return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @PostMapping("/updateUserDivision")
    public ResponseEntity<Object> updateUserDivision(@RequestBody UserProfileForm userProfileForm) {
	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> updateUserDivision()");
	}
	Long selectedDivId = userProfileForm.getDivId();
	String userPin = userProfileForm.getUserPin().toUpperCase();

	FocusDivision divIDAdd = focusDivisionService.getFocusDivisionById(selectedDivId).get();
	UserProfile userProfileAdd = userProfileService.getUserProfile(userPin).get();
	userProfileAdd.addDiv(divIDAdd);
	userProfileService.updateUserProfile(userProfileAdd);

	List<FocusDivision> asgndFocusDivisions = focusDivisionService.getUserFocusDivision(userPin);

	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< updateUserDivision()");
	}
	return new ResponseEntity<Object>(asgndFocusDivisions, HttpStatus.OK);
    }

    @PostMapping("/deleteUserDivision")
    public ResponseEntity<Object> deleteUserDivision(@RequestBody UserProfileForm userProfileForm) {

	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> deleteUserDivision()");
	}
	Long asgndDivId = userProfileForm.getUserDivId();
	String userPin = userProfileForm.getUserPin().toUpperCase();

	FocusDivision divID = new FocusDivision(asgndDivId);
	UserProfile userProfile = userProfileService.getUserProfile(userPin).get();
	userProfile.removeDiv(divID);
	userProfileService.updateUserProfile(userProfile);

	List<FocusDivision> asgndFocusDivisions = focusDivisionService.getUserFocusDivision(userPin);

	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< deleteUserDivision()");
	}
	return new ResponseEntity<Object>(asgndFocusDivisions, HttpStatus.OK);
    }

    @PostMapping("/updateUserAccount")
    public ResponseEntity<Object> updateUserAccount(@RequestBody UserProfileForm userProfileForm) {

	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> updateUserAccount()");
	}

	Long selectedAccId = userProfileForm.getAccId();
	String userPin = userProfileForm.getUserPin().toUpperCase();

	FocusAccount accIDAdd = focusAccountService.getFocusAccountById(selectedAccId).get();
	UserProfile userAccProfileAdd = userProfileService.getUserProfile(userPin).get();
	userAccProfileAdd.addAcc(accIDAdd);
	userProfileService.updateUserProfile(userAccProfileAdd);

	List<FocusAccount> asgndFocusAccount = focusAccountService.getUserFocusAccount(userPin);

	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< updateUserAccount()");
	}
	return new ResponseEntity<Object>(asgndFocusAccount, HttpStatus.OK);
    }

    @PostMapping("/deleteUserAccount")
    public ResponseEntity<Object> deleteUserAccount(@RequestBody UserProfileForm userProfileForm) {

	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> deleteUserAccount()");
	}
	Long asgndAccId = userProfileForm.getUserAccId();
	String userPin = userProfileForm.getUserPin().toUpperCase();

	FocusAccount accIDDel = new FocusAccount(asgndAccId);
	UserProfile userAccProfileDel = userProfileService.getUserProfile(userPin).get();
	userAccProfileDel.removeAcc(accIDDel);
	userProfileService.updateUserProfile(userAccProfileDel);

	List<FocusAccount> asgndFocusAccount = focusAccountService.getUserFocusAccount(userPin);
	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< deleteUserAccount()");
	}
	return new ResponseEntity<Object>(asgndFocusAccount, HttpStatus.OK);
    }

    @PostMapping("/updateUserCountry")
    public ResponseEntity<Object> updateUserCountry(@RequestBody UserProfileForm userProfileForm) {

	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> updateUserCountry()");
	}
	Long selectedCtryId = userProfileForm.getCtryId();
	String userPin = userProfileForm.getUserPin().toUpperCase();

	FocusCountry ctryIDAdd = focusCountryService.getFocusCountryById(selectedCtryId).get();
	UserProfile userCtryProfileAdd = userProfileService.getUserProfile(userPin).get();
	userCtryProfileAdd.addCtry(ctryIDAdd);
	userProfileService.updateUserProfile(userCtryProfileAdd);

	List<FocusCountry> asgndFocusCountry = focusCountryService.getUserFocusCountry(userPin);
	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< updateUserCountry()");
	}
	return new ResponseEntity<Object>(asgndFocusCountry, HttpStatus.OK);
    }

    @PostMapping("/deleteUserCountry")
    public ResponseEntity<Object> deleteUserCountry(@RequestBody UserProfileForm userProfileForm) {

	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> deleteUserCountry()");
	}
	Long asgndCtryId = userProfileForm.getUserCtryId();
	String userPin = userProfileForm.getUserPin().toUpperCase();

	FocusCountry ctryIDDel = new FocusCountry(asgndCtryId);
	UserProfile userCtryProfileDel = userProfileService.getUserProfile(userPin).get();
	userCtryProfileDel.removeCtry(ctryIDDel);
	userProfileService.updateUserProfile(userCtryProfileDel);

	List<FocusCountry> asgndFocusCountry = focusCountryService.getUserFocusCountry(userPin);
	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< deleteUserCountry()");
	}
	return new ResponseEntity<Object>(asgndFocusCountry, HttpStatus.OK);
    }

    @PostMapping("/updateUserTechnology")
    public ResponseEntity<Object> updateUserTechnology(@RequestBody UserProfileForm userProfileForm) {

	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> updateUserTechnology()");
	}
	Long selectedTechId = userProfileForm.getTechId();
	String userPin = userProfileForm.getUserPin().toUpperCase();

	FocusTechnology techIDAdd = focusTechnologyService.getFocusTechnologyById(selectedTechId).get();
	UserProfile usertechProfileAdd = userProfileService.getUserProfile(userPin).get();
	usertechProfileAdd.addTech(techIDAdd);
	userProfileService.updateUserProfile(usertechProfileAdd);

	List<FocusTechnology> asgndFocusTechnology = focusTechnologyService.getUserFocusTechnology(userPin);
	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< updateUserTechnology()");
	}
	return new ResponseEntity<Object>(asgndFocusTechnology, HttpStatus.OK);
    }

    @PostMapping("/deleteUserTechnology")
    public ResponseEntity<Object> deleteUserTechnology(@RequestBody UserProfileForm userProfileForm) {

	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> deleteUserTechnology()");
	}
	Long asgndTechId = userProfileForm.getUserTechId();
	String userPin = userProfileForm.getUserPin().toUpperCase();

	FocusTechnology techIDDel = new FocusTechnology(asgndTechId);
	UserProfile userTechrofileDel = userProfileService.getUserProfile(userPin).get();
	userTechrofileDel.removeTech(techIDDel);
	userProfileService.updateUserProfile(userTechrofileDel);

	List<FocusTechnology> asgndFocusTechnology = focusTechnologyService.getUserFocusTechnology(userPin);
	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< deleteUserTechnology()");
	}
	return new ResponseEntity<Object>(asgndFocusTechnology, HttpStatus.OK);
    }

    /**
     * Method to insert the selected Market vertical Level1 and Level2 for the user
     * pin
     * 
     * @param userProfileForm (UserPin,MrktVrtLvl1Id,MrktVrtLvl2Id)
     * @return ResponseEntity with the given Map (Market Vertical Level1 and Leve2
     *         List) and status code
     */
    @PostMapping("/updateUserMarketVerticalLevel2")
    public ResponseEntity<Object> updateUserMarketVerticalLevel2(@RequestBody UserProfileForm userProfileForm) {

	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> updateUserMarketVerticalLevel2()");
	}

	UserMarketVerticalLevel userMarketVerticalLevelObj = getUserMarketVerticalLevel(
		userProfileForm.getUserPin().toUpperCase(), userProfileForm.getMrktVrtLvl1Id(),
		userProfileForm.getMrktVrtLvl2Id());

	userMarketVerticalLevelService.updateUserMarketVertical(userMarketVerticalLevelObj);

	MultiValueMap<String, Object> userMarketVerticalMap = getMultipleValueMapMrktVrtLvl(
		userProfileForm.getUserPin().toUpperCase(), userProfileForm.getMrktVrtLvl1Id());

	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< updateUserMarketVerticalLevel2()");
	}
	return new ResponseEntity<Object>(userMarketVerticalMap, HttpStatus.OK);
    }

    /**
     * Method to delete the selected assigned market vertical Leve1 and Level2 and
     * return the list of assigned Level1 and Level2 segments
     * 
     * @param userProfileForm (UserPin,UserMrktVrtLvl1Id,UserMrktVrtLvl2Id)
     * @return {@link ResponseEntity} with the list assigned Level1 and Level2
     *         Market Vertical Lists
     */
    @PostMapping("/deleteUserMarketVerticalLevel2")
    public ResponseEntity<Object> deleteUserMarketVerticalLevel2(@RequestBody UserProfileForm userProfileForm) {

	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> deleteUserMarketVerticalLevel2()");
	}
	UserMarketVerticalLevel userMarketVerticalLevelObj = getUserMarketVerticalLevel(
		userProfileForm.getUserPin().toUpperCase(), userProfileForm.getUserMrktVrtLvl1Id(),
		userProfileForm.getUserMrktVrtLvl2Id());

	userMarketVerticalLevelService.deleteUserMarketVertical(userMarketVerticalLevelObj);

	MultiValueMap<String, Object> userMarketVerticalListAfterDelete = getMultipleValueMapMrktVrtLvl(
		userProfileForm.getUserPin().toUpperCase(), userProfileForm.getUserMrktVrtLvl1Id());

	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< deleteUserMarketVerticalLevel2()");
	}
	return new ResponseEntity<Object>(userMarketVerticalListAfterDelete, HttpStatus.OK);
    }

    /**
     * Method to instantiate and return UserMarketVerticalLevel object
     * 
     * @param userPin
     * @param mrktVrtLvl1Id
     * @param mrktVrtLvl2Id
     * @return instantiated UserMarketVerticalLevel object for the provided
     *         parameters
     */
    private UserMarketVerticalLevel getUserMarketVerticalLevel(String userPin, Long mrktVrtLvl1Id, Long mrktVrtLvl2Id) {

	UserMarktVrtLvlId userMarktVrtLvlIdObj = new UserMarktVrtLvlId(userPin, mrktVrtLvl1Id, mrktVrtLvl2Id);
	UserProfile userMrktVrtLvl2ProfileAdd = new UserProfile(userPin);
	FocusMarketVerticalLevel1 userFocusMarketVerticalLevel1 = new FocusMarketVerticalLevel1(mrktVrtLvl1Id);
	FocusMarketVerticalLevel2 focusMarketVerticalLevel2 = new FocusMarketVerticalLevel2(mrktVrtLvl2Id);

	UserMarketVerticalLevel userMarketVerticalLevelObj = new UserMarketVerticalLevel(userMarktVrtLvlIdObj,
		userMrktVrtLvl2ProfileAdd, userFocusMarketVerticalLevel1, focusMarketVerticalLevel2);

	return userMarketVerticalLevelObj;
    }

    /**
     * Method to return the Map containing Market Vertical Level1 and Level2 list
     * assigned for the user.
     * 
     * @param userPin
     * @param mrktVrtLvl1Id
     * @return Map containing Market Vertical Level1 and Level2 list assigned for
     *         the user.
     */
    private MultiValueMap<String, Object> getMultipleValueMapMrktVrtLvl(String userPin, Long mrktVrtLvl1Id) {
	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> getMultipleValueMapMrktVrtLvl()");
	}

	List<FocusMarketVerticalLevel1> userMrktVrtlvl1List = focusMrktVrtLvl1Service
		.getUserFocusMarketVerticalLevel1(userPin);
	List<FocusMarketVerticalLevel2> userMrktVrtlvl2List = focusMrktVrtLvl2Service
		.getUserFocusMarketVerticalLevel2(userPin, mrktVrtLvl1Id);

	MultiValueMap<String, Object> userMarketVerticalMap = new LinkedMultiValueMap<>();
	userMarketVerticalMap.set("userMrktVrtlvl1List", userMrktVrtlvl1List);
	userMarketVerticalMap.set("userMrktVrtlvl2List", userMrktVrtlvl2List);

	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< getMultipleValueMapMrktVrtLvl()");
	}
	return userMarketVerticalMap;
    }

    @PostMapping("/updateUserProfitCenter")
    public ResponseEntity<Object> updateUserProfitCenter(@RequestBody UserProfileForm userProfileForm) {

	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> updateUserProfitCenter()");
	}
	UserPrftCtrId userPrftCtrIdObj = new UserPrftCtrId(userProfileForm.getUserPin().toUpperCase(),
		userProfileForm.getPrftCtrId());
	UserProfile userprftCtrProfileAdd = new UserProfile(userProfileForm.getUserPin().toUpperCase());
	FocusProfitCenter focusProfitCenter = new FocusProfitCenter(userProfileForm.getPrftCtrId());

	UserProfitCenter userProfitCenterObj = new UserProfitCenter();
	userProfitCenterObj.setId(userPrftCtrIdObj);
	userProfitCenterObj.setUserProfile(userprftCtrProfileAdd);
	userProfitCenterObj.setFocusProfitCenter(focusProfitCenter);

	focusProfitCenterService.updateUserProfitCenter(userProfitCenterObj);
	List<FocusProfitCenter> userPrftCtrList = focusProfitCenterService
		.getUserFocusProfitCenter(userProfileForm.getUserPin().toUpperCase());

	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< updateUserProfitCenter()");
	}
	return new ResponseEntity<Object>(userPrftCtrList, HttpStatus.OK);
    }

    @PostMapping("/deleteUserProfitCenter")
    public ResponseEntity<Object> deleteUserProfitCenter(@RequestBody UserProfileForm userProfileForm) {

	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> deleteUserProfitCenter()");
	}
	UserPrftCtrId userPrftCtrIdObj = new UserPrftCtrId(userProfileForm.getUserPin().toUpperCase(),
		userProfileForm.getUserPrftCtrId());
	UserProfile userprftCtrProfileRemove = new UserProfile(userProfileForm.getUserPin().toUpperCase());
	FocusProfitCenter focusProfitCenter = new FocusProfitCenter(userProfileForm.getUserPrftCtrId());

	UserProfitCenter userProfitCenterObj = new UserProfitCenter();
	userProfitCenterObj.setId(userPrftCtrIdObj);
	userProfitCenterObj.setUserProfile(userprftCtrProfileRemove);
	userProfitCenterObj.setFocusProfitCenter(focusProfitCenter);

	focusProfitCenterService.deleteUserProfitCenter(userProfitCenterObj);
	focusGscService.deleteAllUserGsc(userProfileForm.getUserPin().toUpperCase(),
		userProfileForm.getUserPrftCtrId());

	List<FocusProfitCenter> userPrftCtrList = focusProfitCenterService
		.getUserFocusProfitCenter(userProfileForm.getUserPin().toUpperCase());
	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< deleteUserProfitCenter()");
	}
	return new ResponseEntity<Object>(userPrftCtrList, HttpStatus.OK);
    }

    public UserProfitCenter getUserProfitCenter(String userPin, Long prftCtrId) {
	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> getUserProfitCenter()");
	}
	UserPrftCtrId userPrftCtrIdObj = new UserPrftCtrId(userPin, prftCtrId);
	UserProfile userprftCtrProfileRemove = new UserProfile(userPin);
	FocusProfitCenter focusProfitCenter = new FocusProfitCenter(prftCtrId);

	UserProfitCenter userProfitCenterObj = new UserProfitCenter();
	userProfitCenterObj.setId(userPrftCtrIdObj);
	userProfitCenterObj.setUserProfile(userprftCtrProfileRemove);
	userProfitCenterObj.setFocusProfitCenter(focusProfitCenter);
	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< getUserProfitCenter()");
	}
	return userProfitCenterObj;
    }

    @PostMapping("/updateUserGscCode")
    public ResponseEntity<Object> updateUserGscCode(@RequestBody UserProfileForm userProfileForm) {

	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> updateUserGscCode()");
	}
	UserProfile userGscProfileObj = new UserProfile(userProfileForm.getUserPin().toUpperCase());
	FocusProfitCenter focusProfitCenterObj = new FocusProfitCenter(userProfileForm.getPrftCtrId());
	FocusGSC focusGscObj = new FocusGSC(userProfileForm.getGscId());
	UserGSCId UserGSCIdObj = new UserGSCId(userProfileForm.getUserPin().toUpperCase(),
		userProfileForm.getPrftCtrId(), userProfileForm.getGscId());

	UserGSC userGSCObj = new UserGSC();
	userGSCObj.setId(UserGSCIdObj);
	userGSCObj.setUserProfile(userGscProfileObj);
	userGSCObj.setFocusProfitCenter(focusProfitCenterObj);
	userGSCObj.setFocusGsc(focusGscObj);

	focusProfitCenterService.updateUserProfitCenter(
		getUserProfitCenter(userProfileForm.getUserPin().toUpperCase(), userProfileForm.getPrftCtrId()));
	focusGscService.updateUserGscCode(userGSCObj);

	List<FocusProfitCenter> userPrftCtrList = focusProfitCenterService
		.getUserFocusProfitCenter(userProfileForm.getUserPin().toUpperCase());

	List<FocusGSC> userGscList = focusGscService.getUserGscCode(userProfileForm.getUserPin().toUpperCase(),
		userProfileForm.getPrftCtrId());

	MultiValueMap<String, Object> userPrftCtrGscMap = new LinkedMultiValueMap<>();
	userPrftCtrGscMap.add("userPrftCtrList", userPrftCtrList);
	userPrftCtrGscMap.add("userGscList", userGscList);

	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< updateUserGscCode()");
	}
	return new ResponseEntity<Object>(userPrftCtrGscMap, HttpStatus.OK);
    }

    @PostMapping("/deleteUserGscCode")
    public ResponseEntity<Object> deleteUserGscCode(@RequestBody UserProfileForm userProfileForm) {

	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> deleteUserGscCode()");
	}
	UserProfile userGscProfileObj = new UserProfile(userProfileForm.getUserPin().toUpperCase());
	FocusProfitCenter focusProfitCenterObj = new FocusProfitCenter(userProfileForm.getUserPrftCtrId());
	FocusGSC focusGscObj = new FocusGSC(userProfileForm.getUserGscId());
	UserGSCId UserGSCIdObj = new UserGSCId(userProfileForm.getUserPin().toUpperCase(),
		userProfileForm.getUserPrftCtrId(), userProfileForm.getUserGscId());

	UserGSC userGSCObj = new UserGSC();
	userGSCObj.setId(UserGSCIdObj);
	userGSCObj.setUserProfile(userGscProfileObj);
	userGSCObj.setFocusProfitCenter(focusProfitCenterObj);
	userGSCObj.setFocusGsc(focusGscObj);

	focusGscService.deleteUserGscCode(userGSCObj);

	MultiValueMap<String, Object> userPrftCtrGscMap = getMultipleValueMapPrftCtrGsc(
		userProfileForm.getUserPin().toUpperCase(), userProfileForm.getUserPrftCtrId());

	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< deleteUserGscCode()");
	}
	return new ResponseEntity<Object>(userPrftCtrGscMap, HttpStatus.OK);
    }

    private MultiValueMap<String, Object> getMultipleValueMapPrftCtrGsc(String userPin, Long prftCtrId) {
	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> getMultipleValueMapPrftCtrGsc()");
	}
	List<FocusProfitCenter> userPrftCtrList = focusProfitCenterService.getUserFocusProfitCenter(userPin);
	List<FocusGSC> userGscList = focusGscService.getUserGscCode(userPin, prftCtrId);
	MultiValueMap<String, Object> userPrftCtrGscMap = new LinkedMultiValueMap<>();
	userPrftCtrGscMap.add("userPrftCtrList", userPrftCtrList);
	userPrftCtrGscMap.add("userGscList", userGscList);
	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< getMultipleValueMapPrftCtrGsc()");
	}
	return userPrftCtrGscMap;
    }

    @PostMapping("/checkDeviceType")
    public void checkDeviceType(@RequestBody String isMobile) {
    if (LOG.isTraceEnabled()) {
    	LOG.trace("Is Mobile/Tablet device:"+isMobile);
    	}
    }
    


}
