package com.mmm.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmm.model.FocusTechnology;
import com.mmm.repository.FocusTechnologyRepository;

@Service
public class FocusTechnologyService {
	@Autowired
	private FocusTechnologyRepository focusTechRepo;
	
	public List<FocusTechnology> getAllFocusTechnology() {
		List<FocusTechnology> accList = new LinkedList<FocusTechnology>();
		focusTechRepo.findAll().forEach(accList::add);
		return accList;
	}

	public List<FocusTechnology> getUserFocusTechnology(String id) {
		List<FocusTechnology> userAccList = new LinkedList<FocusTechnology>();
		focusTechRepo.findByUsersUserPin(id).forEach(userAccList::add);
		return userAccList;
	}

	public Optional<FocusTechnology> getFocusTechnologyById(Long id) {
		return focusTechRepo.findById(id);
	}
}
