package com.rest.gb;

import Controllers.UserController;
import Models.User;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("UserResources")
public class UserResource {

	@GET
	@Path("Users")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<User> getAllUsers() throws Exception {
		return UserController.getInstance().SearchAll();
	}

	@GET
	@Path("User/{user_id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<User> getUser(@PathParam("user_id") int user_id) throws Exception {
		User obj = new User();
		obj.setUser_id(user_id);
		return UserController.getInstance().Search(obj);
	}

	@POST
	@Path("User")
	public String saveUser(User obj) throws Exception {
		UserController.getInstance().Save(obj);
		return "User Saved";
	}

	@PUT
	@Path("User")
	public String updateUser(User obj) throws Exception {
		UserController.getInstance().Update(obj);
		return "User Updated";
	}

	@DELETE
	@Path("User/{user_id}")
	public String deleteUser(@PathParam("user_id") int user_id) throws Exception {
		User obj = new User();
		obj.setUser_id(user_id);
		UserController.getInstance().Delete(obj);
		return "User Deleted";
	}
}