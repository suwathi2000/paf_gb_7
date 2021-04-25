package Controllers;

import java.sql.ResultSet;

import DataBaseConnector.ConnectorUser;

public class Usercheck {
	ConnectorUser con_u=ConnectorUser.getInstance();
	
	
	public int checkUser(int user_id) {
		int res_user_id=0;
		try {
			con_u.getConnection();
			ResultSet rset_user = con_u.srh("SELECT * FROM user WHERE user_id   = '" + user_id + "'");
			if (rset_user.next()) {
				res_user_id=rset_user.getInt(7);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return res_user_id;
	}
	
}
