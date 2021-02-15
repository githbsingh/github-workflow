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

import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;


public class LinkTest {
	private String description;
	private String link;
	private String fullLink;
	private String status;
	private String statusMessage;
	private double time;

	/**
	 * Default Constructor
	 */
	public LinkTest() {
		this("Not defined", "Not defined");
	}

	/**
	 * Constructor that takes in a link and description
	 * @param link
	 * @param description
	 */
	public LinkTest(String link, String description) {
		setLink(link);
		setDescription(description);
		setStatus("Unknown");
		setStatusMessage("");
		setTime(-1);
	}

	/**
	 * @param string
	 */
	public void setDescription(String string) {
		description = string;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param string
	 */
	public void setLink(String string) {
		link = string;
	}

	/**
	 * @return
	 */
	public String getLink() {
		return link;
	}

	public String getFullLink() {
		return fullLink;
	}

	public void setFullLink(String value) {
		fullLink = value;
	}
	/**
	 * @param string
	 */
	public void setStatus(String string) {
		status = string;
	}

	/**
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param string
	 */
	public void setStatusMessage(String string) {
		statusMessage = string;
	}

	/**
	 * @return
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * @param d
	 */
	public void setTime(double d) {
		time = d;
	}

	/**
	 * @return
	 */
	public double getTime() {
		return time;
	}

	/**
	 * Test the link
	 * @param request
	 */
	public void test(HttpServletRequest request) {
		String protocol = "https://";
		if(getLink().indexOf(protocol) < 0) {
			//set the protocol
			StringBuffer newLink = new StringBuffer();
			newLink.append(protocol);
			newLink.append(request.getServerName());
			//String env = System.getProperty("mmm.app.env").toLowerCase();
			//if("local".equalsIgnoreCase(env)){
			//newLink.append(':');
			//newLink.append(request.getServerPort());
			//}
			if(getLink().indexOf('/') != 0) {
				//no slash starting
				newLink.append('/');
			}

			newLink.append(getLink());
			setFullLink(newLink.toString());
		} else {
			setFullLink(getLink());
		}

		//get the time it takes to get to the link
		long startTime = System.currentTimeMillis();
		sendMsgToURL();
		long endTime = System.currentTimeMillis();
		setTime(((double) (endTime - startTime)) / 1000);
	}

	/**
	 * Actually test if I can get to this link
	 */
	private void sendMsgToURL() {
		HttpURLConnection httpCon = null;

		try {
			URL url = new URL(getFullLink());
			httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setUseCaches(false);

			try {
				int respCode = httpCon.getResponseCode();
				if((respCode >= 200) && (respCode < 300)) { // between 200 and 300 are good
					setStatus("PASS");
				} else {
					setStatus("FAIL");
					setStatusMessage(httpCon.getHeaderField(0));
				}
			} catch(Exception ae) {
				setStatus("FAIL");
				setStatusMessage(httpCon.getHeaderField(0));
			}

			// read the content of the page

			/*
			InputStream in = httpCon.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String r = null;
            while ((r = br.readLine()) != null) {
                            System.out.println(r);
            }
			*/
		} catch(Exception e) {
			setStatusMessage(e.getClass().getName() + " : " + e.getMessage());
		}
	}
}
