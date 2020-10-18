package com.jakartamp.intro.itemsservice.client;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jakartamp.intro.itemsservice.model.Stock;

/**
 *
 * @author Adam M. Gamboa G
 */
@Path("/stock")
public interface StockClient {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<Stock> getAll();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/status/{status}")
	List<Stock> getByStatus(@PathParam("status") String status);

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Stock findById(@PathParam("id") String id);

}
