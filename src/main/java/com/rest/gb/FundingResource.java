package com.rest.gb;

import Models.Funding;
import Controllers.FundingController;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("FundingResources")
public class FundingResource {

	@GET
	@Path("Fundings")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Funding> getAllFundings() throws Exception {
		return FundingController.getInstance().SearchAll();
	}

	@GET
	@Path("Funding/{funding_id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Funding> getFunding(@PathParam("funding_id") int funding_id) throws Exception {
		Funding obj = new Funding();
		obj.setFunding_id(funding_id);
		return FundingController.getInstance().Search(obj);
	}

	@POST
	@Path("Funding")
	public String saveFunding(Funding obj) throws Exception {
		FundingController.getInstance().Save(obj);
		return "Funding Saved";
	}

	@PUT
	@Path("Funding")
	public String updateFunding(Funding obj) throws Exception {
		FundingController.getInstance().Update(obj);
		return "Funding Updated";
	}

	@DELETE
	@Path("Funding/{funding_id}")
	public String deleteFunding(@PathParam("funding_id") int funding_id) throws Exception {
		Funding obj = new Funding();
		obj.setFunding_id(funding_id);
		FundingController.getInstance().Delete(obj);
		return "Funding Deleted";
	}
}