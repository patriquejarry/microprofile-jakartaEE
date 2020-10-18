package com.jakartamp.intro.itemsservice.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.jakartamp.intro.itemsservice.model.Groceries;
import com.jakartamp.intro.itemsservice.model.Stock;
import com.jakartamp.intro.itemsservice.repository.GroceriesRepository;

/**
 *
 * @author Adam M. Gamboa G
 */
@ApplicationScoped
public class GroceriesService {

	@Inject
	private GroceriesRepository repository;

	@Inject
	private StockService stockService;

	public List<Groceries> getAll() {
		return repository.getAll().stream()
			.map(g -> {
				final String stockId = repository.getStockId(g.getId());
				final Stock stock = stockService.getStock(stockId);
				g.setStock(stock);
				return g;
			})
			.collect(Collectors.toList());
	}

	public Optional<Groceries> findById(final long id) {
		final Optional<Groceries> groceries = repository.findById(id);
		if (groceries.isPresent()) {
			final Groceries g = groceries.get();
			final String stockId = repository.getStockId(g.getId());
			final Stock stock = stockService.getStock(stockId);
			g.setStock(stock);
		}
		return groceries;
	}

}
