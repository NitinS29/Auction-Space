package com.auctionspace.dao;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.auctionspace.model.LoginModel;
import com.auctionspace.model.UserModel;
import com.auctionspace.utils.ConnectionUtility;

import java.sql.ResultSet;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class ManageUsersDao implements IManageUsersDao{
	@Autowired
	DataSource dataSource;

	@Autowired 
	JdbcTemplate jdbctemp;
	
	ManageUsersDao() {
		dataSource= ConnectionUtility.getDataSource();
		jdbctemp= new JdbcTemplate(dataSource);
	}

	public static ManageUsersDao instance = new ManageUsersDao();
	private static Logger logger = Logger.getLogger(ManageUsersDao.class);

	public static ManageUsersDao getInstance() {
		return instance;
	}

	@Override
	public void registerUser(UserModel user) {
		String insertUserQuery = "insert into User (fname, mname, lname, emailId, username, password, phone, address) values(?,?,?,?,?,?,?,?)";
		logger.debug("query " + insertUserQuery + user.getFname() + user.getMname() + user.getLname()
				+ user.getEmail() +user.getUsername() +user.getPassword() + user.getPhone() + user.getAddress());
		jdbctemp.update(insertUserQuery, new Object[] { user.getFname(), user.getMname(),user.getLname()
				, user.getEmail(),user.getUsername(),user.getPassword(), user.getPhone(), user.getAddress()});
	}

	@Override
	public UserModel validateUser(LoginModel login) {
		String selectUserQuery = "select * from User where username='" + login.getUsername() + "' and password='" + login.getPassword()
		+ "'";
		List<UserModel> users = jdbctemp.query(selectUserQuery, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}

	@Override
	public String getUserEmailId(String fname) {
		List<UserModel> user = null;
		try {
			String query = "select * from User where username='" + fname + "'";
			logger.debug("query " + query);
			user = jdbctemp.query(query, new UserMapper());
			return user.get(0).getEmail().toString();
		} 
		catch(Exception e) {
			logger.error("Error in getUserEmailId: " + e.getMessage());
		}
		return null;
	}
	
	public UserModel getUserDetails(String username) {
		UserModel user = null;
		try {
			String query = "select * from User where username='" + username + "'";
			logger.info("in getUserDetails: " + query);
			user = jdbctemp.queryForObject(query,  new UserMapper());
		} catch (Exception e) {
			logger.error("Error in getUserDetails: " + e.getMessage());
		}
		return user;
	}
}

class UserMapper implements RowMapper<UserModel> {
	private static Logger logger = Logger.getLogger(UserMapper.class);
	public UserModel mapRow(ResultSet rs, int arg1) throws SQLException {
		UserModel user = new UserModel();
		try {
			user.setFname(rs.getString("fname"));
			user.setMname(rs.getString("mname"));
			user.setLname(rs.getString("lname"));
			user.setEmail(rs.getString("emailId"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getInt("phone"));
			user.setAddress(rs.getString("address"));
			user.setUserType(rs.getString("usertype"));
			logger.info("Returning from usermapper" + user.getEmail());}
		catch(Exception e) {
			logger.debug("Error in usermapper");
		}
		return user;
	}

}
