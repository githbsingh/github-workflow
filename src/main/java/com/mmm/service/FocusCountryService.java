package com.mmm.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmm.model.FocusCountry;
import com.mmm.repository.FocusCountryRepository;

@Service
public class FocusCountryService {

	@Autowired
	private FocusCountryRepository focusCtryRepo;
	
	public List<FocusCountry> getAllFocusCountry() {
		List<FocusCountry> ctryList = new LinkedList<FocusCountry>();
		focusCtryRepo.findAll().forEach(ctryList::add);
		return ctryList;
	}

	public List<FocusCountry> getUserFocusCountry(String id) {
		List<FocusCountry> userCtryList = new LinkedList<FocusCountry>();
		focusCtryRepo.findByUsersUserPin(id).forEach(userCtryList::add);
		return userCtryList;
	}

	public Optional<FocusCountry> getFocusCountryById(Long id) {
		return focusCtryRepo.findById(id);
	}
}
