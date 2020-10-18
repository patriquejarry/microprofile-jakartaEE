package com.jakartamp.intro.stockservice.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;

import com.jakartamp.intro.stockservice.model.Stock;
import com.jakartamp.intro.stockservice.repository.StockRepository;

/**
 *
 * @author Adam M. Gamboa G
 */
@ApplicationScoped
public class StockService {

	@Inject
	private StockRepository repository;

	@Counted(name = "StockService.getAll_counter")
	@Timed(name = "StockService.getAll_timer")
	public List<Stock> getAll() {
		return repository.getData();
	}

	@Timed
	public List<Stock> getByStatus(final String status) {
		return repository.getData().stream()
			.filter(s -> s.getStatus().equals(status))
			.collect(Collectors.toList());
	}

	@Metered
	public Optional<Stock> findById(final String id) {
		return repository.getData().stream()
			.filter(s -> s.getId().equals(id))
			.findFirst();
	}
}
