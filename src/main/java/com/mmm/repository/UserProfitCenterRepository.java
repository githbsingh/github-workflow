package com.mmm.repository;

import org.springframework.data.repository.CrudRepository;

import com.mmm.model.UserPrftCtrId;
import com.mmm.model.UserProfitCenter;

public interface UserProfitCenterRepository extends CrudRepository<UserProfitCenter, UserPrftCtrId> {

}
