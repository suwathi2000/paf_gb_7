package Controllers;

import Models.Purchase;
import DataBaseConnector.ConnectorCart;
import DataBaseConnector.ConnectorProject;
import DataBaseConnector.ConnectorPurchase;
import DataBaseConnector.ConnectorUser;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PurchaseController {

	ConnectorPurchase con = ConnectorPurchase.getInstance();
	ConnectorProject con_p = ConnectorProject.getInstance();
	ConnectorUser con_u=ConnectorUser.getInstance();
	ConnectorCart con_c=ConnectorCart.getInstance();
	
	private PurchaseController() {
	}

	private static final PurchaseController obj = new PurchaseController();

	public static PurchaseController getInstance() {
		return obj;
	}

	public int Save(Purchase data) throws Exception {
		con_p.getConnection();
		con_u.getConnection();
		con_c.getConnection();
		ResultSet rset_user = con_u.srh("SELECT * FROM user WHERE user_id   = '" + data.getUser_user_id() + "'");
		ResultSet rset = con_p.srh("SELECT * FROM project WHERE project_id  = '" + data.getProduct_id() + "'");
		ResultSet rs_cart = con_c.srh("SELECT * FROM cart WHERE cart_id  = '" + data.getCart_id() + "'");
		
		if (rset.next() && rset_user.next() && rs_cart.next()) {
			con.getConnection();
			con.aud("INSERT INTO purchase(purchase,discount,date_time,user_user_id,product_id,cart_id) values ('" + data.getPurchase_id() + "','" + data.getDiscount() + "','"
					+ data.getDate_time() + "','" + data.getUser_user_id() + "','" + data.getProduct_id() + "'"
							+ ",'" + data.getCart_id() + "') ");
			return 1;
		}else {
			return 0;
		}		
		
	}

	public int Update(Purchase data) throws Exception {
		con_p.getConnection();
		con_u.getConnection();
		con_c.getConnection();
		ResultSet rset_user = con_u.srh("SELECT * FROM user WHERE user_id   = '" + data.getUser_user_id() + "'");
		ResultSet rset = con_p.srh("SELECT * FROM project WHERE project_id  = '" + data.getProduct_id() + "'");
		ResultSet rs_cart = con_c.srh("SELECT * FROM cart WHERE cart_id  = '" + data.getCart_id() + "'");
		
		if (rset.next() && rset_user.next() && rs_cart.next()) {
			con.getConnection();
			con.aud("UPDATE purchase SET discount  = '" + data.getDiscount() + "',date_time  = '" + data.getDate_time()
					+ "',user_user_id  = '" + data.getUser_user_id() + "',product_id  = '" + data.getProduct_id() + "'"
							+ ",cart_id  = '" + data.getCart_id() + "' WHERE purchase_id = '" + data.getPurchase_id()
					+ "'");
			return 1;
		}else {
			return 0;
		}
		
		
	}

	public int Delete(Purchase data) throws Exception {
		con_p.getConnection();
		con_u.getConnection();
		con_c.getConnection();
		ResultSet rset_user = con_u.srh("SELECT * FROM user WHERE user_id   = '" + data.getUser_user_id() + "'");
		ResultSet rset = con_p.srh("SELECT * FROM project WHERE project_id  = '" + data.getProduct_id() + "'");
		ResultSet rs_cart = con_c.srh("SELECT * FROM cart WHERE cart_id  = '" + data.getCart_id() + "'");
		
		if (rset.next() && rset_user.next() && rs_cart.next()) {
			con.getConnection();
			con.aud("DELETE FROM purchase WHERE purchase_id = '" + data.getPurchase_id() + "'");
			return 1;
		}else {
			return 0;
		}
		
	}

	public List<Purchase> SearchAll() throws Exception {
		List<Purchase> objList = new ArrayList<Purchase>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM purchase");
		while (rset.next()) {
			Purchase obj = new Purchase();
			obj.setPurchase_id(rset.getInt(1));
			obj.setDiscount(rset.getDouble(2));
			obj.setDate_time(rset.getString(3));
			obj.setUser_user_id(rset.getInt(4));
			obj.setProduct_id(rset.getInt(5));
			obj.setCart_id(rset.getInt(6));
			objList.add(obj);
		}

		return objList;
	}

	public List<Purchase> Search(Purchase data) throws Exception {
		List<Purchase> objList = new ArrayList<Purchase>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM purchase WHERE purchase_id = '" + data.getPurchase_id() + "'");
		while (rset.next()) {
			Purchase obj = new Purchase();
			obj.setPurchase_id(rset.getInt(1));
			obj.setDiscount(rset.getDouble(2));
			obj.setDate_time(rset.getString(3));
			obj.setUser_user_id(rset.getInt(4));
			obj.setProduct_id(rset.getInt(5));
			obj.setCart_id(rset.getInt(6));
			objList.add(obj);
		}

		return objList;
	}

}