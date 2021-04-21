package com.rest.gb;

import Models.Purchase;
import Controllers.PurchaseController;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("PurchaseResources")
public class PurchaseResource {

	@GET
	@Path("Purchases")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Purchase> getAllPurchases() throws Exception {
		return PurchaseController.getInstance().SearchAll();
	}

	@GET
	@Path("Purchase/{purchase_id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Purchase> getPurchase(@PathParam("purchase_id") int purchase_id) throws Exception {
		Purchase obj = new Purchase();
		obj.setPurchase_id(purchase_id);
		return PurchaseController.getInstance().Search(obj);
	}

	@POST
	@Path("Purchase")
	public String savePurchase(Purchase obj) throws Exception {
		PurchaseController.getInstance().Save(obj);
		return "Purchase Saved";
	}

	@PUT
	@Path("Purchase")
	public String updatePurchase(Purchase obj) throws Exception {
		PurchaseController.getInstance().Update(obj);
		return "Purchase Updated";
	}

	@DELETE
	@Path("Purchase/{purchase_id}")
	public String deletePurchase(@PathParam("purchase_id") int purchase_id) throws Exception {
		Purchase obj = new Purchase();
		obj.setPurchase_id(purchase_id);
		PurchaseController.getInstance().Delete(obj);
		return "Purchase Deleted";
	}
}