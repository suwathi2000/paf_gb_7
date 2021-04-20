package Controllers;

import Models.Funding;
import DataBaseConnector.ConnectorFunding;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FundingController {

	ConnectorFunding con = ConnectorFunding.getInstance();

	private FundingController() {
	}

	private static final FundingController obj = new FundingController();

	public static FundingController getInstance() {
		return obj;
	}

	public void Save(Funding data) throws Exception {
		con.getConnection();
		con.aud("INSERT INTO funding(name,description,loyalty,date_time) values ('" + data.getName() + "','"
				+ data.getDescription() + "','" + data.getLoyalty() + "','" + data.getDate_time() + "') ");
	}

	public void Update(Funding data) throws Exception {
		con.getConnection();
		con.aud("UPDATE funding SET name  = '" + data.getName() + "',description  = '" + data.getDescription()
				+ "',loyalty  = '" + data.getLoyalty() + "',date_time  = '" + data.getDate_time()
				+ "' WHERE funding_id = '" + data.getFunding_id() + "'");
	}

	public void Delete(Funding data) throws Exception {
		con.getConnection();
		con.aud("DELETE FROM funding WHERE funding_id = '" + data.getFunding_id() + "'");
	}

	public List<Funding> SearchAll() throws Exception {
		List<Funding> objList = new ArrayList<Funding>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM funding");
		while (rset.next()) {
			Funding obj = new Funding();
			obj.setFunding_id(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setDescription(rset.getString(3));
			obj.setLoyalty(rset.getInt(4));
			obj.setDate_time(rset.getString(5));
			objList.add(obj);
		}

		return objList;
	}

	public List<Funding> Search(Funding data) throws Exception {
		List<Funding> objList = new ArrayList<Funding>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM funding WHERE funding_id = '" + data.getFunding_id() + "'");
		while (rset.next()) {
			Funding obj = new Funding();
			obj.setFunding_id(rset.getInt(1));
			obj.setName(rset.getString(2));
			obj.setDescription(rset.getString(3));
			obj.setLoyalty(rset.getInt(4));
			obj.setDate_time(rset.getString(5));
			objList.add(obj);
		}

		return objList;
	}

}