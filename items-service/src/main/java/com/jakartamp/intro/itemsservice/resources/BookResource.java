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

import com.jakartamp.intro.itemsservice.model.Book;
import com.jakartamp.intro.itemsservice.services.BookService;

/**
 *
 * @author Adam M. Gamboa
 */
@ApplicationScoped
@Path("/books")
public class BookResource {

	@Inject
	private BookService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAll() {
		return service.getAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@APIResponses(value = {
		@APIResponse(responseCode = "404", description = "Book not found"),
		@APIResponse(responseCode = "200", description = "Book is found and returned", //
			content = @Content(schema = @Schema(implementation = Book.class)))
	})
	@Operation(summary = "Finds a book by its Id", description = "Finds a book by its Id, it also consumes the Stock service to return"
		+ "the stock availability of the book. If no book is found a 404 is return")
	public Book findById(
		@Parameter(description = "The Id of the Book ", required = true) //
		@PathParam("id") final Long id) {
		return service.findById(id)
			.orElseThrow(NotFoundException::new);
	}

}
