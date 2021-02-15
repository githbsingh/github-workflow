/**
 * 
 */
package com.mmm.repository;

import org.springframework.data.repository.CrudRepository;

import com.mmm.model.UserMarketVerticalLevel;
import com.mmm.model.UserMarktVrtLvlId;

/**
 * @author a2krjzz
 *
 */
public interface UserMarketVerticalRepository extends CrudRepository<UserMarketVerticalLevel, UserMarktVrtLvlId> {

}
