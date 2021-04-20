package Controllers;

import DataBaseConnector.ConnectorUser;
import Models.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserController {

	ConnectorUser con = ConnectorUser.getInstance();

	private UserController() {
	}

	private static final UserController obj = new UserController();

	public static UserController getInstance() {
		return obj;
	}

	public void Save(User data) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO user(full_name,user_type,username,password,date_time) values ('" + data.getFull_name()
				+ "','" + data.getUser_type() + "','" + data.getUsername() + "','" + data.getPassword() + "','"
				+ data.getDate_time() + "') ");
	}

}