package com.mmm.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author a2krjzz
 * Class containing the method to delete all assigned GSC Codes for an user.
 *
 */
@Repository
public class UserGscCodeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Delete all assigned GSC Codes for an user.
	 * @param userPin
	 * @param userPrftCtrId
	 */
	@Transactional
	public void deleteWithQuery(String userPin, Long userPrftCtrId) {
		entityManager.createNativeQuery(
				"DELETE FROM t_asgnd_user_gsc WHERE user_profile_user_pin = ? AND focus_profit_center_focus_prft_ctr_id = ?")
				.setParameter(1, userPin)
				.setParameter(2, userPrftCtrId)
				.executeUpdate();
	}

}
