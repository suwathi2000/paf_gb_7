package Controllers;

import Models.Purchase;
import DataBaseConnector.ConnectorPurchase;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PurchaseController {

	ConnectorPurchase con = ConnectorPurchase.getInstance();

	private PurchaseController() {
	}

	private static final PurchaseController obj = new PurchaseController();

	public static PurchaseController getInstance() {
		return obj;
	}

	public void Save(Purchase data) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO purchase(discount,date_time,user_user_id) values ('" + data.getDiscount() + "','"
				+ data.getDate_time() + "','" + data.getUser_user_id() + "') ");
	}

	public void Update(Purchase data) throws Exception {
		con.getConnection();
		con.aud("UPDATE purchase SET discount  = '" + data.getDiscount() + "',date_time  = '" + data.getDate_time()
				+ "',user_user_id  = '" + data.getUser_user_id() + "' WHERE purchase_id = '" + data.getPurchase_id()
				+ "'");
	}

	public void Delete(Purchase data) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM purchase WHERE purchase_id = '" + data.getPurchase_id() + "'");
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
			objList.add(obj);
		}

		return objList;
	}

}