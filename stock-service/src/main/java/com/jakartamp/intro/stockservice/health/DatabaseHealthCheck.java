package com.jakartamp.intro.stockservice.health;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;

/**
 *
 * @author Adam M. Gamboa G
 */
@ApplicationScoped
@Liveness
@Readiness
public class DatabaseHealthCheck implements HealthCheck {

	@Override
	public HealthCheckResponse call() {
		final HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("database");
		try {
			return responseBuilder.up()
				.withData("name", "my_dummy_db")
				.build();
		} catch (final Exception ex) {// SqlException
			return responseBuilder.down()
				.build();
		}
	}
}
