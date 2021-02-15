package com.mmm.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mmm.model.ApplicationProfile;

public interface ApplicationProfileRepository extends CrudRepository<ApplicationProfile,Long> {
	public List<ApplicationProfile> findTop5ApplicationProfileByUserIdAndSentDateAndFeedbackOrderByUserId (String userId,Date sentDate,int feedback);
	
	
	@Modifying
    @Transactional
	@Query("update ApplicationProfile a set a.feedback=:feedback where a.userId = :userId and a.applicationId =:applicationId")
	public int updateApplicationProfileFeedback(@Param("userId") String userId,@Param("applicationId") long applicationId,@Param("feedback") int feedback);

	}
