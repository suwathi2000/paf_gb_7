package DataBaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectorFunding {

	private ConnectorFunding() {
	}

	private static final ConnectorFunding obj = new ConnectorFunding();

	public static ConnectorFunding getInstance() {
		return obj;
	}

	private static Connection con;
	ResultSet rs;

	public Connection getConnection() throws Exception {
		if (con == null) {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_rest_funding", "root", "Roshan@15528");
		}
		return con;
	}

	public int aud(String sql) throws Exception {
		getConnection();
		Statement st = con.createStatement();
		int i = st.executeUpdate(sql);
		return i;
	}

	public ResultSet srh(String sql) throws Exception {
		getConnection();
		Statement st = con.createStatement();
		rs = st.executeQuery(sql);
		return rs;
	}
}