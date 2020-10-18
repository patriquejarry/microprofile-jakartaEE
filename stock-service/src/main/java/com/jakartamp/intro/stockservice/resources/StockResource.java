package com.jakartamp.intro.stockservice.resources;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.jakartamp.intro.stockservice.model.Stock;
import com.jakartamp.intro.stockservice.services.StockService;

/**
 *
 * @author Adam M. Gamboa G
 */
@Path("/stock")
@ApplicationScoped
public class StockResource {

	@Inject
	private StockService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Stock> getAll() {
		return service.getAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/status/{status}")
	public List<Stock> getByStatus(@PathParam("status") final String status) {
		return service.getByStatus(status);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Stock findById(@PathParam("id") final String id) {
		final Optional<Stock> stock = service.findById(id);
		if (stock.isPresent()) {
			return stock.get();
		}
		throw new WebApplicationException("Stock not found", Response.Status.NOT_FOUND);
	}

}
