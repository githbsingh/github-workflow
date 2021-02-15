package com.mmm.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmm.model.UserMarketVerticalLevel;
import com.mmm.repository.UserMarketVerticalRepository;

/**
 * @author a2krjzz
 * 
 *         This class consists of update and delete methods to add or remove
 *         selected Level1 and Level2 segments
 */
@Service
public class UserMarketVerticalLevelService {

    private static final Logger LOG = LoggerFactory.getLogger(UserMarketVerticalLevelService.class.getName());

    @Autowired
    private UserMarketVerticalRepository userMarketVerticalRepo;

    /**
     * Method to assign a new selected Level1 and Level2 segment.
     * 
     * @param userMarketVerticalLevelObj Object of UserMarketVerticalLevel
     */
    public void updateUserMarketVertical(UserMarketVerticalLevel userMarketVerticalLevelObj) {
	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> updateUserMarketVertical()");
	}

	userMarketVerticalRepo.save(userMarketVerticalLevelObj);

	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< updateUserMarketVertical()");
	}
    }

    /**
     * Method to remove an assigned Level1 and Level2 segment.
     * 
     * @param userMarketVerticalLevelObj Object of UserMarketVerticalLevel
     */
    public void deleteUserMarketVertical(UserMarketVerticalLevel userMarketVerticalLevelObj) {
	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> deleteUserMarketVertical()");
	}
	
	userMarketVerticalRepo.delete(userMarketVerticalLevelObj);
	
	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> deleteUserMarketVertical()");
	}
    }

}
