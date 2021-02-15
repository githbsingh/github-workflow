package com.mmm.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmm.model.FocusAccount;
import com.mmm.repository.FocusAccountRepository;

/**
 * @author a2krjzz
 *
 */
@Service
public class FocusAccountService {

    private static final Logger LOG = LoggerFactory.getLogger(FocusAccountService.class.getName());

    @Autowired
    private FocusAccountRepository focusAccRepo;

    /**
     * This method is used to fetch the list of all available FOCUS ACCOUNTS.
     * 
     * @return List of all Focus Accounts
     */
    public List<FocusAccount> getAllFocusAccount() {
	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> getAllFocusAccount()");
	}
	List<FocusAccount> accList = new LinkedList<FocusAccount>();
	focusAccRepo.findAll().forEach(accList::add);
	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< getAllFocusAccount()");
	}
	return accList;
    }

    /**
     * This method is used to fetch the list of FOCUS ACCOUNT(S) currently assigned
     * for the given user pin.
     * 
     * @param id (user pin)
     * @return list of focus account(s) assigned for given user pin
     */
    public List<FocusAccount> getUserFocusAccount(String id) {
	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> getUserFocusAccount()");
	}
	List<FocusAccount> userAccList = new LinkedList<FocusAccount>();
	focusAccRepo.findByUsersUserPin(id).forEach(userAccList::add);
	if (LOG.isTraceEnabled()) {
	    LOG.trace("<< getUserFocusAccount()");
	}
	return userAccList;
    }

    /**
     * This method is used to get the FOCUS ACCOUNT by the given focus account Id.
     * 
     * @param id (FOCUS ACCOUNT Id)
     * @return focus account
     */
    public Optional<FocusAccount> getFocusAccountById(Long id) {
	if (LOG.isTraceEnabled()) {
	    LOG.trace(">> getFocusAccountById()");
	}
	return focusAccRepo.findById(id);
    }
}
