package com.auctionspace.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectionUtility {
	private static Logger logger = Logger.getLogger(ConnectionUtility.class);
	static IConnectionData connectionData = new ConnectionData();
	
	public static Connection getConnection() {
		MysqlDataSource ds = null;
		Connection connect = null;
		try {
			ds = new MysqlDataSource();
			ds.setUrl(connectionData.getUrl());
			ds.setUser(connectionData.getUsername());
			ds.setPassword(connectionData.getPassword());
			connect = ds.getConnection();
		} catch (SQLException e) {
			logger.error("Error in connection utility: " + e.getMessage());
		}
		return connect;
	}
}
