package com.jakartamp.intro.itemsservice.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.jakartamp.intro.itemsservice.model.Book;
import com.jakartamp.intro.itemsservice.model.Stock;
import com.jakartamp.intro.itemsservice.repository.BookRepository;

/**
 *
 * @author Adam M. Gamboa G
 */
@ApplicationScoped
public class BookService {

	@Inject
	private BookRepository repository;

	@Inject
	private StockService stockService;

	public List<Book> getAll() {
		return repository.getAll().stream()
			.map(b -> {
				final String stockId = repository.getStockId(b.getId());
				final Stock stock = stockService.getStock(stockId);
				b.setStock(stock);
				return b;
			})
			.collect(Collectors.toList());
	}

	public Optional<Book> findById(final long id) {
		final Optional<Book> book = repository.findById(id);
		if (book.isPresent()) {
			final Book b = book.get();
			final String stockId = repository.getStockId(b.getId());
			final Stock stock = stockService.getStock(stockId);
			b.setStock(stock);
		}
		return book;
	}

}
