package com.jakartamp.intro.itemsservice.services;

import java.net.URI;
import java.net.URISyntaxException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.faulttolerance.exceptions.CircuitBreakerOpenException;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import com.jakartamp.intro.itemsservice.client.StockClient;
import com.jakartamp.intro.itemsservice.model.Stock;

/**
 *
 * @author Adam M. Gamboa G
 */
@RequestScoped
public class StockService {

	@Inject
	@ConfigProperty(name = "stockservice.api.url")
	private String apiUrl;

	@Timeout(value = 5000)
	@Retry(maxRetries = 3, delay = 500)
	@Fallback(applyOn = CircuitBreakerOpenException.class, fallbackMethod = "getStockFallBack")
	@CircuitBreaker(successThreshold = 10, requestVolumeThreshold = 4, failureRatio = 0.75, delay = 1000)
	public Stock getStock(final String id) {
		final URI apiUri = getURI();
		final StockClient stockClient = RestClientBuilder.newBuilder()
			.baseUri(apiUri)
			.build(StockClient.class);
		return stockClient.findById(id);
	}

	private URI getURI() {
		try {
			return new URI(apiUrl);
		} catch (final URISyntaxException ex) {
			throw new RuntimeException("URL not valid:" + apiUrl);
		}
	}

	@SuppressWarnings("unused")
	private Stock getStockFallBack(final String stockId) {
		System.out.println("Getting stock for stockId " + stockId + " has failed. The Circuit breaker is open");
		// Some more logic here.
		return null;
	}

}
