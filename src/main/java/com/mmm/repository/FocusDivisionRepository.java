/**
 * 
 */
package com.mmm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mmm.model.FocusDivision;

/**
 * @author a2krjzz
 *
 */
public interface FocusDivisionRepository extends CrudRepository<FocusDivision, Long> {
	
	public List<FocusDivision> findByUsersUserPin(String userPin); 

}
