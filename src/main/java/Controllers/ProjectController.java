package Controllers;

import Models.Project;
import Models.User;
import DataBaseConnector.ConnectorProject;
import DataBaseConnector.ConnectorFunding;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProjectController {

	ConnectorProject con = ConnectorProject.getInstance();
	ConnectorFunding conuser = ConnectorFunding.getInstance();
	private ProjectController() {
		
	}

	private static final ProjectController obj = new ProjectController();

	public static ProjectController getInstance() {
		return obj;
	}

	public int Save(Project data) throws Exception {
		conuser.getConnection();
		ResultSet rset = conuser.srh("SELECT * FROM funding WHERE funding_id = '" + data.getFunding_id() + "'");
		
		if (rset.next()) {
			con.getConnection();
			con.aud("INSERT INTO project(category,topic,price,details,date_time,funding_id) values ('" + data.getCategory() + "','"
					+ data.getTopic() + "','" + data.getPrice() + "','" + data.getDetails() + "','" + data.getDate_time()
					+ "','"+data.getFunding_id()+"')");
			return 1;
		}else {
			return 0;
		}
		
	}

	public int Update(Project data) throws Exception {
		int res=0;
		try {
			conuser.getConnection();
			ResultSet rset = conuser.srh("SELECT * FROM funding WHERE funding_id = '" + data.getFunding_id() + "'");
			
			if (rset.next()) 
			{
				con.getConnection();
				con.aud("UPDATE project SET category  = '" + data.getCategory() + "',topic  = '" + data.getTopic()
						+ "',price  = '" + data.getPrice() + "',details  = '" + data.getDetails() + "',date_time  = '"
						+ data.getDate_time() + "',funding_id  = '"+data.getFunding_id()+"' WHERE project_id = '" + data.getProject_id() + "'");
				res=1;
			}else {
				System.out.println("exist funding id "+data.getFunding_id());
				res=0;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return res;

	}

	public void Delete(Project data) throws Exception {
		
		conuser.getConnection();
		ResultSet rset = conuser.srh("SELECT * FROM funding WHERE funding_id = '" + data.getFunding_id() + "'");
		
		if (rset.next()) 
		{
			con.getConnection();
			con.aud("DELETE FROM project WHERE project_id = '" + data.getProject_id() + "'");
		}else {
			System.out.println("no such a funding id "+data.getFunding_id());
		}
		
	}

	public List<Project> SearchAll() throws Exception {
		List<Project> objList = new ArrayList<Project>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM project");
		while (rset.next()) {
			Project obj = new Project();
			obj.setProject_id(rset.getInt(1));
			obj.setCategory(rset.getString(2));
			obj.setTopic(rset.getString(3));
			obj.setPrice(rset.getString(4));
			obj.setDetails(rset.getString(5));
			obj.setDate_time(rset.getString(6));
			obj.setFunding_id(rset.getInt(7));
			objList.add(obj);
		}

		return objList;
	}

	public List<Project> Search(Project data) throws Exception {
		List<Project> objList = new ArrayList<Project>();
		con.getConnection();
		ResultSet rset = con.srh("SELECT * FROM project WHERE project_id = '" + data.getProject_id() + "'");
		while (rset.next()) {
			Project obj = new Project();
			obj.setProject_id(rset.getInt(1));
			obj.setCategory(rset.getString(2));
			obj.setTopic(rset.getString(3));
			obj.setPrice(rset.getString(4));
			obj.setDetails(rset.getString(5));
			obj.setDate_time(rset.getString(6));
			obj.setFunding_id(rset.getInt(7));
			objList.add(obj);
		}

		return objList;
	}

}