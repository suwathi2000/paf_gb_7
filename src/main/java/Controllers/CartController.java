package Controllers;

import Models.Cart;
import DataBaseConnector.ConnectorCart;
import DataBaseConnector.ConnectorProject;
import DataBaseConnector.ConnectorUser;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartController {

	ConnectorCart con = ConnectorCart.getInstance();
	ConnectorProject con_p = ConnectorProject.getInstance();
	ConnectorUser con_u=ConnectorUser.getInstance();
	
	private CartController() {
	}

	private static final CartController obj = new CartController();

	public static CartController getInstance() {
		return obj;
	}

	public int Save(Cart data) throws Exception {
		con_p.getConnection();
		con_u.getConnection();
		ResultSet rset_user = con_u.srh("SELECT * FROM user WHERE user_id   = '" + data.getUser_id() + "'");
		ResultSet rset = con_p.srh("SELECT * FROM project WHERE project_id  = '" + data.getProject_project_id() + "'");
		
		if (rset.next() && rset_user.next()) {
			con.getConnection();
			con.aud("INSERT INTO cart(cart_id,discount,sub_total,project_project_id,user_id) values ('" + data.getCart_id() + "','" + data.getDiscount() + "','"
					+ data.getSub_total() + "','" + data.getProject_project_id() + "','" + data.getUser_id() + "') ");
			return 1;
		}else {
			return 0;
		}
		
	}

	public int Update(Cart data) throws Exception {
		try {
			con_p.getConnection();
			con_u.getConnection();
			con.getConnection();

			ResultSet cartRest = con.srh("SELECT * FROM cart  WHERE cart_id   = '" + data.getCart_id() + "'");
			ResultSet rset_user = con_u.srh("SELECT * FROM user WHERE user_id   = '" + data.getUser_id() + "'");
			ResultSet rset = con_p.srh("SELECT * FROM project WHERE project_id  = '" + data.getProject_project_id() + "'");
			
			if (rset.next() && rset_user.next() && cartRest.next()) {
				con.getConnection();
				con.aud("UPDATE cart SET discount  = '" + data.getDiscount() + "',sub_total  = '" + data.getSub_total()
				+ "',project_project_id  = '" + data.getProject_project_id() + "',"
				+ "user_id  = '" + data.getUser_id() + "' WHERE cart_id = '" + data.getCart_id() + "'");
				
				
			/*	System.err.println("UPDATE cart SET discount  = '" + data.getDiscount() + "',sub_total  = '" + data.getSub_total()
				+ "',project_project_id  = '" + data.getProject_project_id() + "',"
				+ "user_id  = '" + data.getUser_id() + "' WHERE cart_id = '" + data.getCart_id() + "'");
				*/
				
				
				return 1;
			}else {
				return 0;
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return 0;
	}

	public int Delete(Cart data) throws Exception {
		con_p.getConnection();
		con_u.getConnection();
		con.getConnection();

		ResultSet cartRest = con.srh("SELECT * FROM cart  WHERE cart_id   = '" + data.getCart_id() + "'");
		ResultSet rset_user = con_u.srh("SELECT * FROM user WHERE user_id   = '" + data.getUser_id() + "'");
		ResultSet rset = con_p.srh("SELECT * FROM project WHERE project_id  = '" + data.getProject_project_id() + "'");
		
		
		//System.err.println("DELETE FROM cart WHERE cart_id = '" + data.getCart_id() + "'");

		if (rset.next() && rset_user.next() && cartRest.next()) {
			con.getConnection();
			con.aud("DELETE FROM cart WHERE cart_id = '" + data.getCart_id() + "'");
			
			System.err.println("DELETE FROM cart WHERE cart_id = '" + data.getCart_id() + "'");
			
			return 1;
		}else {
			
			System.out.print("error");
			return 0;
		}
		
	}

	public List<Cart> SearchAll() throws Exception {
		List<Cart> objList = new ArrayList<Cart>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM cart");
		while (rset.next()) {
			Cart obj = new Cart();
			obj.setCart_id(rset.getInt(1));
			obj.setDiscount(rset.getDouble(2));
			obj.setSub_total(rset.getString(3));
			obj.setProject_project_id(rset.getInt(4));
			obj.setUser_id(rset.getInt(5));
			objList.add(obj);
		}

		return objList;
	}

	public List<Cart> Search(Cart data) throws Exception {
		List<Cart> objList = new ArrayList<Cart>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM cart WHERE cart_id = '" + data.getCart_id() + "'");
		while (rset.next()) {
			Cart obj = new Cart();
			obj.setCart_id(rset.getInt(1));
			obj.setDiscount(rset.getDouble(2));
			obj.setSub_total(rset.getString(3));
			obj.setProject_project_id(rset.getInt(4));
			obj.setUser_id(rset.getInt(5));
			objList.add(obj);
		}

		return objList;
	}

}