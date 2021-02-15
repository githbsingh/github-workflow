package com.mmm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mmm.model.FocusCountry;

public interface FocusCountryRepository extends CrudRepository<FocusCountry, Long> {

	public List<FocusCountry> findByUsersUserPin(String userPin); 
}
