package Controllers;

import Models.Cart;
import DataBaseConnector.ConnectorCart;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartController {

	ConnectorCart con = ConnectorCart.getInstance();

	private CartController() {
	}

	private static final CartController obj = new CartController();

	public static CartController getInstance() {
		return obj;
	}

	public void Save(Cart data) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO cart(discount,sub_total,project_project_id) values ('" + data.getDiscount() + "','"
				+ data.getSub_total() + "','" + data.getProject_project_id() + "') ");
	}

	public void Update(Cart data) throws Exception {
		con.getConnection();
		con.aud("UPDATE cart SET discount  = '" + data.getDiscount() + "',sub_total  = '" + data.getSub_total()
				+ "',project_project_id  = '" + data.getProject_project_id() + "' WHERE cart_id = '" + data.getCart_id()
				+ "'");
	}

	public void Delete(Cart data) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM cart WHERE cart_id = '" + data.getCart_id() + "'");
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
			objList.add(obj);
		}

		return objList;
	}

}