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
 * 07-25-2008 Chad Poser
 * 06-04-2013 Chad Poser           Relocated for SCA migration to JBOSS
 * 09-26-2013 Chad Poser           Added server/database for db2; Added JDBC major/minor
 *
 */

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceAvailTest {
    private String datasourceName;
    private String description;
    private String status;
    private String statusMessage;
    private String dbServer = null;
    private String dbName = null;
    private String userid = null;
    private String driverInfo = "";
    private String jdbcInfo = "";

    public DataSourceAvailTest(String name, String description) {
        setDatasourceName(name);
        setDescription(description);
        setStatus("");
		setStatusMessage("");
        setDatabaseServer("Unknown");
        setDatabaseName("Unknown");
        setUserID("Unknown");
    }

    public DataSourceAvailTest() {
        setDatasourceName("Unknown");
        setDescription("");
        setStatus("");
		setStatusMessage("");
        setDatabaseServer("Unknown");
        setDatabaseName("Unknown");
        setUserID("Unknown");
    }

	/**
	 * @return
	 */
	public String getDatasourceName() {
		return datasourceName;
	}
	/**
	 * @param string
	 */
	public void setDatasourceName(String string) {
		datasourceName = string;
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
	public void setDescription(String string) {
		description = string;
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
	public void setStatus(String string) {
		status = string;
	}

	/**
	 * @return
	 */
	public String getStatusMessage() {
		return statusMessage;
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
	public String getDatabaseServer() {
		return dbServer;
	}
	/**
	 * @param string
	 */
	public void setDatabaseServer(String value) {
		dbServer = value;
	}
	/**
	 * @return
	 */
	public String getDatabaseName() {
		return dbName;
	}
	/**
	 * @param string
	 */
	public void setDatabaseName(String value) {
		dbName = value;
	}
	/**
	 * @return
	 */
	public String getUserID() {
		return userid;
	}
	/**
	 * @param string
	 */
	public void setUserID(String value) {
		userid = value;
	}
	public String getDriverInformation() {
		return driverInfo;
	}
	public void setDriverInformation(String info) {
		driverInfo = info;
	}
	public String getJDBCInformation() {
		return jdbcInfo;
	}
	public void setJDBCInformation(String info) {
		jdbcInfo = info;
	}
    public void test() {
        DataSource ds = null;
        Connection con = null;
        DatabaseMetaData md = null;

        //do the tests
        InitialContext context;
        try {
            context = new InitialContext();
            ds = (DataSource) context.lookup(getDatasourceName());

            con = ds.getConnection();

            md = con.getMetaData();

            if(md != null) {
            	try {
            		// Format the driver information
            		setDriverInformation(md.getDriverVersion());
            	} catch(Exception e) {/*nothing*/}

            	setJDBCInformation(md.getJDBCMajorVersion() + "." + md.getJDBCMinorVersion());

                //try to get one metadata field
                String dbname = md.getDatabaseProductName();
                if((dbname != null) && (dbname.trim().length() > 0)) {
                   	setStatus("PASS");
                   	setUserID(md.getUserName());
                   	String url = md.getURL();
                   	setDatabaseServer(findDatabaseServer(url));
                   	setDatabaseName(findDatabaseName(url));
                } else {
                    setStatus("FAIL");
                    setStatusMessage("Database metadata is empty");
                   	setUserID(md.getUserName());
                   	String url = md.getURL();
                   	setDatabaseServer(findDatabaseServer(url));
                   	setDatabaseName(findDatabaseName(url));
                }
            } else {
                setStatus("FAIL");
				setStatusMessage("Could not read database metadata");
            }
        } catch(NamingException ne) {
            setStatus("FAIL");
			setStatusMessage("Could not find datasource:\n"+ ne.getMessage());
        } catch(SQLException sqle) {
            setStatus("FAIL");
			setStatusMessage("Could not get connection:\n"+ sqle.getMessage());
        } finally {
            if(con != null) {
                try {
                    con.close();
                } catch(SQLException ignore) {
                }
            }

            if(ds != null) {
                ds = null;
            }
        }
    }
	private String findDatabaseServer(String url) {
		String result = "Unknown Server:####";
		//jdbc:sqlserver://DEVSQL05:1531;respnseBuffering=full;encrypt=false;databaseName=dESCDEV;selectMethod=direct;trustServerCertificate=false;lastUpdateCount=true;
		if (url != null) {

			String key = "jdbc:sqlserver://";
			int start = url.indexOf(key);
			if (start >= 0) {
				result = parse(url,start + key.length(),";");
			} else {
				key =  "jdbc:db2://";
				start = url.indexOf(key);
				if (start >= 0) {
					result = parse(url,start + key.length(),"/");
				}
			}
		}
		return result;
	}
	private String parse(String url, int start, String delim) {
		String result = "";
		String tmp = url.substring(start);
		result = tmp;
		int end = tmp.indexOf(delim);
		if(end >= 0) {
			result = tmp.substring(0,end);
		}
		return result;
	}
	private String findDatabaseName(String url) {
		String result = "Unknown Database";
		//jdbc:sqlserver://DEVSQL05:1531;respnseBuffering=full;encrypt=false;databaseName=dESCDEV;selectMethod=direct;trustServerCertificate=false;lastUpdateCount=true;
		if (url != null) {

			if(url.indexOf("jdbc:sqlserver://") >= 0) {
				String key = "databaseName=";
				int start = url.indexOf(key);
				if (start >= 0) {
					result = parse(url,start + key.length(),";");
				}
			} else if(url.indexOf("jdbc:db2://") >= 0) {
				url = url.substring(11);
				String key = "/";
				int start = url.indexOf(key);
				if (start >= 0) {
					result = parse(url,start + key.length(),";");

				}
			}
		}
		return result;
	}
}
