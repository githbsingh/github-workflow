package com.mmm.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(UserNotFoundException.class.getName());

	public UserNotFoundException(String id) {
		super("Profile not found for the user : " + id.toUpperCase());
		if (LOG.isDebugEnabled()) {
			LOG.debug("-- UserNotFoundException() > Got param: {}", id.toUpperCase());
		}
	}

}
