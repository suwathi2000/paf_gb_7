package com.rest.gb;

import Models.Cart;
import Controllers.CartController;

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
		CartController.getInstance().Save(obj);
		return "Cart Saved";
	}

	@PUT
	@Path("Cart")
	public String updateCart(Cart obj) throws Exception {
		CartController.getInstance().Update(obj);
		return "Cart Updated";
	}

	@DELETE
	@Path("Cart/{cart_id}")
	public String deleteCart(@PathParam("cart_id") int cart_id) throws Exception {
		Cart obj = new Cart();
		obj.setCart_id(cart_id);
		CartController.getInstance().Delete(obj);
		return "Cart Deleted";
	}
}