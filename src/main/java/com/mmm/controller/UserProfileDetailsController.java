package com.mmm.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
import com.mmm.model.UserProfile;
import com.mmm.model.UserProfileForm;
import com.mmm.repository.FocusAccountRepository;
import com.mmm.repository.FocusCountryRepository;
import com.mmm.repository.FocusDivisionRepository;
import com.mmm.repository.FocusGscRepository;
import com.mmm.repository.FocusMarketVerticalLevel1Repository;
import com.mmm.repository.FocusMarketVerticalLevel2Repository;
import com.mmm.repository.FocusProfitCenterRepository;
import com.mmm.repository.FocusTechnologyRepository;
import com.mmm.service.FocusAccountService;
import com.mmm.service.FocusCountryService;
import com.mmm.service.FocusDivisionService;
import com.mmm.service.FocusGscService;
import com.mmm.service.FocusMarketVericalLevel1Service;
import com.mmm.service.FocusMarketVericalLevel2Service;
import com.mmm.service.FocusProfitCenterService;
import com.mmm.service.FocusTechnologyService;
import com.mmm.service.UserProfileService;

@RestController
public class UserProfileDetailsController {

	private static final Logger LOG = LoggerFactory.getLogger(UserProfileDetailsController.class.getName());

	@Autowired
	private UserProfileService userProfileService;

	@Autowired
	private FocusDivisionService focusDivisionService;

	@Autowired
	private FocusAccountService focusAccountService;

	@Autowired
	private FocusCountryService focusCountryService;

	@Autowired
	private FocusTechnologyService focusTechnologyService;

	@Autowired
	private FocusMarketVericalLevel1Service focusMrktVrtLvl1Service;

	@Autowired
	private FocusMarketVericalLevel2Service focusMrktVrtLvl2Service;

	@Autowired
	private FocusProfitCenterService focusProfitCenterService;

	@Autowired
	private FocusGscService focusGscService;

	@Autowired
	private FocusDivisionRepository focusDivRepo;

	@Autowired
	private FocusAccountRepository focusAccRepo;

	@Autowired
	private FocusCountryRepository focusCtryRepo;

	@Autowired
	private FocusMarketVerticalLevel1Repository focusMarketVerticalLevel1Repo;

	@Autowired
	private FocusMarketVerticalLevel2Repository focusMarketVerticalLevel2Repo;

	@Autowired
	private FocusTechnologyRepository focusTechRepo;

	@Autowired
	private FocusGscRepository focusGscRepo;

	@Autowired
	private FocusProfitCenterRepository focusProfitCenterRepo;

	/**
	 * Method to fetch user profile details providing userpin or userName
	 * @param userProfileForm
	 * @return user profile details
	 * @throws {@link UserNotFoundException} 
	 */
	@PostMapping("/getUserProfileInfo")
	public ResponseEntity<Object> getUserProfileInfo(@RequestBody UserProfileForm userProfileForm) {

		if (LOG.isTraceEnabled()) {
			LOG.trace(">> getUserProfileInfo()");
		}

		String id = userProfileForm.getUserPin();
		String name = userProfileForm.getUserName();
		List<String> roleList = Arrays.asList(new String[] { "Product AE", "Market AE", "New AE", "AE Manager", "KeyAccount AE" });

		UserProfile userProfileInfo = new UserProfile();

		if (null != id && (name == null || name.isEmpty())) {
			userProfileInfo = userProfileService.getUserProfile(id)
					.orElseThrow(() -> new UserNotFoundException(userProfileForm.getUserPin()));
		} else if (null != name && (id == null || id.isEmpty())) {
			userProfileInfo = userProfileService.getUserProfileByName(name)
					.orElseThrow(() -> new UserNotFoundException(userProfileForm.getUserName()));
			id = userProfileInfo.getUserPin();
		} else {
			userProfileInfo = userProfileService.getUserProfileByIdAndName(id, name)
					.orElseThrow(() -> new UserNotFoundException(userProfileForm.getUserPin()));
		}

		List<FocusDivision> userDivisionList = getUserFocusDivision(id);
		List<FocusAccount> userAccountList = getUserFocusAccount(id);
		List<FocusCountry> userCountryList = getUserFocusCountry(id);
		List<FocusTechnology> userTechnologyList = getUserFocusTechnology(id);
		List<FocusMarketVerticalLevel1> userMarketVerticalLevel1List = getFocusMarketVerticalLevel1(id);
		List<FocusProfitCenter> userPrftCtrList = getFocusProfitCenter(id);

		MultiValueMap<String, Object> userProfileDetails = new LinkedMultiValueMap<>();
		userProfileDetails.add("userProfileInfo", userProfileInfo);
		userProfileDetails.add("userDivisionList", userDivisionList);
		userProfileDetails.add("userAccountList", userAccountList);
		userProfileDetails.add("userCountryList", userCountryList);
		userProfileDetails.add("userTechnologyList", userTechnologyList);
		userProfileDetails.add("userMarketVerticalLevel1List", userMarketVerticalLevel1List);
		userProfileDetails.add("userPrftCtrList", userPrftCtrList);
		userProfileDetails.add("roleList", roleList);

		if (LOG.isTraceEnabled()) {
			LOG.trace("<< getUserProfileInfo()");
		}
		return new ResponseEntity<Object>(userProfileDetails, HttpStatus.OK);
	}

	/**
	 * Method to load all static dropdown values on page load *
	 * 
	 * @return List for Division, Account, Country, Technology, Market Vertical
	 *         Leve1 and Profit Center
	 */
	@RequestMapping(value = "/getStaticValues", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getStaticValues() {

		if (LOG.isTraceEnabled()) {
			LOG.trace(">> getStaticValues()");
		}
		List<FocusDivision> divList = new LinkedList<FocusDivision>();
		focusDivRepo.findAll().forEach(divList::add);

		List<FocusAccount> accList = new LinkedList<FocusAccount>();
		focusAccRepo.findAll().forEach(accList::add);

		List<FocusCountry> ctryList = new LinkedList<FocusCountry>();
		focusCtryRepo.findAll().forEach(ctryList::add);

		List<FocusTechnology> techList = new LinkedList<FocusTechnology>();
		focusTechRepo.findAll().forEach(techList::add);

		List<FocusMarketVerticalLevel1> mrktVrtlvl1List = new LinkedList<FocusMarketVerticalLevel1>();
		focusMarketVerticalLevel1Repo.findAll().forEach(mrktVrtlvl1List::add);

		List<FocusProfitCenter> focusPrftCtrList = new LinkedList<FocusProfitCenter>();
		focusProfitCenterRepo.findAll().forEach(focusPrftCtrList::add);

		MultiValueMap<String, Object> staticValues = new LinkedMultiValueMap<>();

		staticValues.add("divList", divList);
		staticValues.add("accList", accList);
		staticValues.add("ctryList", ctryList);
		staticValues.add("techList", techList);
		staticValues.add("mrktVrtlvl1List", mrktVrtlvl1List);
		staticValues.add("focusPrftCtrList", focusPrftCtrList);

		if (LOG.isTraceEnabled()) {
			LOG.trace("<< getStaticValues()");
		}
		return new ResponseEntity<Object>(staticValues, HttpStatus.OK);
	}

	/**
	 * Method to return the Market Vertical Leve12 on select of Level1 - FOR STATIC
	 * DROPDOWN
	 * 
	 * @param userProfileForm
	 * @return
	 */
	@PostMapping(value = "/getMarketVerticalLevel2")
	public ResponseEntity<Object> getMarketVerticalLevel2(@RequestBody UserProfileForm userProfileForm) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> getMarketVerticalLevel2()");
		}
		List<FocusMarketVerticalLevel2> mrktVrtlvl2List = getMarketVerticalLvl2(userProfileForm.getMrktVrtLvl1Id());
		return new ResponseEntity<Object>(mrktVrtlvl2List, HttpStatus.OK);
	}

	public List<FocusMarketVerticalLevel2> getMarketVerticalLvl2(Long focusMrktVrtLvl1Id) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> getMarketVerticalLvl2()");
		}
		return focusMarketVerticalLevel2Repo.findByfocusMarketVerticalLevel1_focusMrktVrtLvl1Id(focusMrktVrtLvl1Id);
	}

	@PostMapping(value = "/getUserMarketVerticalLevel2")
	public ResponseEntity<Object> getUserMarketVerticalLevel2(@RequestBody UserProfileForm userProfileForm) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> getUserMarketVerticalLevel2()");
		}
		List<FocusMarketVerticalLevel2> userMrktVrtlvl2List = getUserMarketVerticalLvl2(userProfileForm.getUserPin(),
				userProfileForm.getUserMrktVrtLvl1Id());
		return new ResponseEntity<Object>(userMrktVrtlvl2List, HttpStatus.OK);
	}

	public List<FocusMarketVerticalLevel2> getUserMarketVerticalLvl2(@PathVariable String id,
			@PathVariable long focusMrktVrtLvl1Id) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> getUserMarketVerticalLvl2()");
		}
		return focusMrktVrtLvl2Service.getUserFocusMarketVerticalLevel2(id, focusMrktVrtLvl1Id);
	}

	/**
	 * Method to return list of GSC names on select of Profit center - FOR STATIC
	 * DROPDOWN
	 * 
	 * @param userProfileForm
	 * @return
	 */

	@PostMapping(value = "/getGscCode")
	public ResponseEntity<Object> getGscCode(@RequestBody UserProfileForm userProfileForm) {
		List<FocusGSC> gscList = getGsc(userProfileForm.getPrftCtrId());
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> getGscCode()");
		}
		return new ResponseEntity<Object>(gscList, HttpStatus.OK);
	}

	@PostMapping(value = "/getUserGscCode")
	public ResponseEntity<Object> getUserGscCode(@RequestBody UserProfileForm userProfileForm) {
		List<FocusGSC> userGscList = getUserGscCode(userProfileForm.getUserPin(), userProfileForm.getUserPrftCtrId());
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> getUserGscCode()");
		}
		return new ResponseEntity<Object>(userGscList, HttpStatus.OK);
	}

	public List<FocusGSC> getUserGscCode(@PathVariable String id, @PathVariable long focusPrftCtrId) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> getUserGscCode()");
		}
		return focusGscService.getUserGscCode(id, focusPrftCtrId);
	}

	/**
	 * Method to return list of GSC for the given profit center
	 * 
	 * @param focusPrftCtrId
	 * @return GSC list
	 */
	private List<FocusGSC> getGsc(Long focusPrftCtrId) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> getGsc()");
		}
		return focusGscRepo.findByFocusProfitCenter_FocusPrftCtrId(focusPrftCtrId);
	}

	//@RequestMapping(value = "/getUserProfile/{id}/focusDivision")
	public List<FocusDivision> getUserFocusDivision(@PathVariable String id) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> getUserFocusDivision()");
		}
		return focusDivisionService.getUserFocusDivision(id);
	}

	//@RequestMapping(value = "/getUserProfile/{id}/focusAccount")
	public List<FocusAccount> getUserFocusAccount(@PathVariable String id) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> getUserFocusAccount()");
		}
		return focusAccountService.getUserFocusAccount(id);
	}

	//@RequestMapping(value = "/getUserProfile/{id}/focusCountry")
	public List<FocusCountry> getUserFocusCountry(@PathVariable String id) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> getUserFocusCountry()");
		}
		return focusCountryService.getUserFocusCountry(id);
	}

	//@RequestMapping(value = "/getUserProfile/{id}/focusTechnology")
	public List<FocusTechnology> getUserFocusTechnology(@PathVariable String id) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> getUserFocusTechnology()");
		}
		return focusTechnologyService.getUserFocusTechnology(id);
	}

	//@RequestMapping(value = "/getUserProfile/{id}/focusMarketVerticalLevel1")
	public List<FocusMarketVerticalLevel1> getFocusMarketVerticalLevel1(@PathVariable String id) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> getFocusMarketVerticalLevel1()");
		}
		return focusMrktVrtLvl1Service.getUserFocusMarketVerticalLevel1(id);
	}

	//@RequestMapping(value = "/getUserProfile/{id}/focusProfitCenter")
	public List<FocusProfitCenter> getFocusProfitCenter(@PathVariable String id) {
		if (LOG.isTraceEnabled()) {
			LOG.trace(">> getFocusProfitCenter()");
		}
		return focusProfitCenterService.getUserFocusProfitCenter(id);
	}
}
