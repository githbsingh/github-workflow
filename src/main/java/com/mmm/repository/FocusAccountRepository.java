package com.mmm.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.mmm.model.FocusAccount;

public interface FocusAccountRepository extends CrudRepository<FocusAccount, Long> {

	/**
	 * This method is used to fetch the list of FOCUS ACCOUNT(S) currently assigned
	 * for the given user pin.
	 * 
	 * @param userPin
	 * @return list of focus account(s) assigned for given user pin
	 */
	public List<FocusAccount> findByUsersUserPin(String userPin);
}
