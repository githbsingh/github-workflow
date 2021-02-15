package com.mmm.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mmm.model.ProdApplication;

public interface ProdApplicationRepository extends CrudRepository<ProdApplication,Long> {
	

	public List<ProdApplication>  findTop5ProdApplicationByUserIdAndSentDateAndFeedbackOrderByUserId (String userId,Date sentDate, int feedback);
	
	@Modifying
    @Transactional
	@Query("update ProdApplication p set p.feedback=:feedback where p.userId = :userId and p.applicationId =:applId")
	public int updateProdApplicationFeedback(@Param("userId") String userId,@Param("applId") String applId,@Param("feedback") int feedback);


}
