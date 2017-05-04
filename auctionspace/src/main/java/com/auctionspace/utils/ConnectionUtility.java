package com.auctionspace.utils;

import org.apache.log4j.Logger;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectionUtility {
	private static Logger logger = Logger.getLogger(ConnectionUtility.class);
	static ConnectionData connectionData = new ConnectionData();
	
	public static MysqlDataSource getDataSource() {
		MysqlDataSource ds = null;
		try {
			ds = new MysqlDataSource();
			ds.setUrl(connectionData.getUrl());
			ds.setUser(connectionData.getUsername());
			ds.setPassword(connectionData.getPassword());
		} catch (Exception e) {
			logger.error("Error in connection utility: " + e.getMessage());
		}
		return ds;
	}
}