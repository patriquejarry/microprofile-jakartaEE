package com.jakartamp.intro.itemsservice.resources;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import com.jakartamp.intro.itemsservice.model.Groceries;
import com.jakartamp.intro.itemsservice.services.GroceriesService;

/**
 *
 * @author Adam M. Gamboa
 */
@ApplicationScoped
@Path("/groceries")
public class GroceriesResource {

	@Inject
	private GroceriesService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Groceries> getAll() {
		return service.getAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@APIResponses(value = {
		@APIResponse(responseCode = "404", description = "Book not found"),
		@APIResponse(responseCode = "200", description = "Book is found and returned", //
			content = @Content(schema = @Schema(implementation = Groceries.class)))
	})
	@Operation(summary = "Finds a Grocery by its Id", description = "Finds a Grocery by its Id, it also consumes the Stock service to return"
		+ "the stock availability of the Grocery. If no Grocery is found a 404 is return")
	public Groceries findById(
		@Parameter(description = "The Id of the Grocery", required = true) //
		@PathParam("id") final Long id) {
		return service.findById(id)
			.orElseThrow(NotFoundException::new);
	}

}
