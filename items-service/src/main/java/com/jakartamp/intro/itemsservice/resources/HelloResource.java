package com.jakartamp.intro.itemsservice.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 *
 * @author Huevo
 */
@Path("/hello")
public class HelloResource {

	@Inject
	@ConfigProperty(name = "hello.message", defaultValue = "Not value found")
	private String message;

	@GET
	public String message() {
		return message;
	}
}
