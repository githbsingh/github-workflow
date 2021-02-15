package com.mmm.sca.avail;

/*
 * This is an unpublished work containing 3M confidential and
 * proprietary information.  Disclosure, use or reproduction without the
 * written authorization of 3M is prohibited.  If publication occurs,
 * the following notice applies:
 *
 * Copyright 2013 3M. All rights reserved.
 *
 * Description:
 *
 *
 * Revision History
 * Date       Author               Description of Change
 * ---------- -------------------- ----------------------------------
 * 06-04-2013 Chad Poser	       JBOSS
 *
 */

public class SystemPropertyTest {

	private String desc = null;
	private String name = null;
	private String value = null;
	private String status = "PASS";

	public SystemPropertyTest(String desc, String name) {
		this.desc = desc;
		this.name = name;
	}
	public String getDescription() {
		return desc;
	}
	public String getName() {
		return name;
	}
	public String getValue() {
		return value;
	}
	public String getStatus() {
		return status;
	}
	public void test() {
		if(getName() != null) {
			value = System.getProperty(getName());
			if(value == null) {
				status = "FAIL";
			}
		} else {
			status = "FAIL";
		}
	}
}
