/**
 * 
 */
package com.mmm.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmm.model.FocusDivision;
import com.mmm.repository.FocusDivisionRepository;

/**
 * @author a2krjzz
 *
 */
@Service
public class FocusDivisionService {

	@Autowired
	private FocusDivisionRepository focusDivRepo;

	public List<FocusDivision> getAllFocusDivision() {
		List<FocusDivision> divList = new LinkedList<FocusDivision>();
		focusDivRepo.findAll().forEach(divList::add);
		return divList;
	}

	public List<FocusDivision> getUserFocusDivision(String id) {
		List<FocusDivision> userDivList = new LinkedList<FocusDivision>();
		focusDivRepo.findByUsersUserPin(id).forEach(userDivList::add);
		return userDivList;
	}

	public Optional<FocusDivision> getFocusDivisionById(Long id) {
		return focusDivRepo.findById(id);
	}

}
