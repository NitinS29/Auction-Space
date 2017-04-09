package com.auctionspace.dao;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.auctionspace.dao.ItemsDao.ItemMapper;
import com.auctionspace.model.LoginModel;
import com.auctionspace.model.UserModel;

//import org.json.JSONArray;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
//import javax.swing.tree.RowMapper;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
//import javax.swing.tree.TreePath;

@Service
public class ManageUsersDao implements IManageUsersDao{

	@Autowired
	DataSource dataSource;

	@Autowired 
	JdbcTemplate jdbctemp;

	public static ManageUsersDao instance = new ManageUsersDao();
	private static Logger logger = Logger.getLogger(ManageUsersDao.class);

	public static ManageUsersDao getInstance() {
		return instance;
	}

	/*public ResultSet getUser() {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conUtility.createStatement();
			String query = "SELECT * FROM User";
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			logger.error("Error in getAllItems: " + e.getMessage());
		}
		return resultSet;
	}

	public ResultSet addUser() {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conUtility.createStatement();
			String query = "insert into User values(1, 'Jones','','Smith' , '1985-03-27', 'jones29@gmail.com', '9087650991', 'Address');";
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			logger.error("Error in addItem: " + e.getMessage());
		}
		return resultSet;
	}*/

	@Override
	public void registerUser(UserModel user) {
		String insertUserQuery = "insert into User values(?,?,?,?,?,?,?,?,?)";
		jdbctemp.update(insertUserQuery, new Object[] { user.getFname(), user.getMname(),user.getLname()
				, user.getEmail(),user.getUsername(),user.getPassword(), user.getPhone(), user.getAddress(), user.getUserType()});
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
		Map<String, Object> user = null;
		try {

			String query = "select emailId from User where username=?";
			logger.debug("query " + query);
			user = jdbctemp.queryForMap(query, new Object[]{fname});
			return user.get("emailId").toString();
		} 
		catch(Exception e) {
			logger.error("Error in getUserEmailId: " + e.getMessage());
		}
		return null;
	}
}

class UserMapper implements RowMapper<UserModel> {
	public UserModel mapRow(ResultSet rs, int arg1) throws SQLException {
		UserModel user = new UserModel();
		user.setFname(rs.getString("fname"));
		user.setMname(rs.getString("mname"));
		user.setLname(rs.getString("lname"));
		user.setEmail(rs.getString("emailId"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setPhone(rs.getInt("phone"));
		user.setAddress(rs.getString("address"));
		user.setUserType(rs.getString("userType"));
		return user;
	}

}
