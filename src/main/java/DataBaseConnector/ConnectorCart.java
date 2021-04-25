package DataBaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectorCart {

	private ConnectorCart() {
	}

	private static final ConnectorCart obj = new ConnectorCart();

	public static ConnectorCart getInstance() {
		return obj;
	}

	private static Connection con;
	ResultSet rs;

	public Connection getConnection() throws Exception {
		if (con == null) {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_rest_cart_7?serverTimezone=UTC", "root", "");
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