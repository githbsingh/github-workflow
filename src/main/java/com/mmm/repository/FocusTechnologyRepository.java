package com.mmm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mmm.model.FocusTechnology;

public interface FocusTechnologyRepository extends CrudRepository<FocusTechnology, Long> {

	public List<FocusTechnology> findByUsersUserPin(String userPin);

}
