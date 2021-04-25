package com.rest.gb;

import Models.Cart;
import Controllers.CartController;
import Controllers.Usercheck;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("CartResources")
public class CartResource {

	@GET
	@Path("Carts")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Cart> getAllCarts() throws Exception {
		return CartController.getInstance().SearchAll();
	}

	@GET
	@Path("Cart/{cart_id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Cart> getCart(@PathParam("cart_id") int cart_id) throws Exception {
		Cart obj = new Cart();
		obj.setCart_id(cart_id);
		return CartController.getInstance().Search(obj);
	}

	@POST
	@Path("Cart")
	public String saveCart(Cart obj) throws Exception {
		String res=null;
		Usercheck uc=new Usercheck();
		int role_id=uc.checkUser(obj.getUser_id());
		if( role_id> 0) {
			
			if(role_id == 1) {
				System.err.println("user");
				int x=CartController.getInstance().Save(obj);
					if(x==1) {
						res= "Cart Saved";
					}else {
						res= "Cart not Save";
					}
			}else if(role_id == 2) {
				System.err.println("Admin");
			}else if(role_id == 3) {
				System.err.println("Res");
			}
			
		}else {
			System.err.println("no such a user role");
		}
		
			return res;
	}

	@PUT
	@Path("Cart")
	public String updateCart(Cart obj) throws Exception {
		int x=CartController.getInstance().Update(obj);
		if(x==1) {
			return "Cart Updated";
		}else {
			return "Cart not Updated";
		}
		
	}

	@DELETE
	@Path("Cart")
	public String deleteCart(Cart obj) throws Exception {
		//Cart obj = new Cart();
		//obj.setCart_id(cart_id);
		int x=CartController.getInstance().Delete(obj);
		if(x==1) {
			return "Cart Deleted";
		}else {
			return "Cart not Deleted";
		}
		
	}
}