package com.mmm.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mmm.model.ApplicationProfile;
import com.mmm.model.OpportunityItem;
import com.mmm.model.ProdApplication;


public interface OpportunityItemRepository extends CrudRepository<OpportunityItem,Long>{
	

	
	//@Query("From OpportunityItem where userId = :userId order by optyId")
	//public List<OpportunityItem> getOpportunityByUserId(@Param("userId") String userId);
	//int rel=-1;
	public List<OpportunityItem> findTop5OpportunityItemByUserIdAndSentDateAndFeedbackOrderByUserId(String userId,Date sentDate,int feedback);

	
	@Modifying
    @Transactional
	@Query("update OpportunityItem o set o.feedback=:feedback where o.userId = :userId and o.optyId =:optyId")
	public int updateOpportunityItemFeedback(@Param("userId") String userId,@Param("optyId") String optyId,@Param("feedback") int feedback);
	

}
