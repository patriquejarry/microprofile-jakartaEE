package com.jakartamp.intro.stockservice.repository;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.jakartamp.intro.stockservice.model.Stock;

/**
 *
 * @author Adam M. Gamboa G
 */
//@Singleton
@ApplicationScoped
public class StockRepository {

	private final List<Stock> data = new ArrayList<>();

	public StockRepository() {
		final Stock stock1 = new Stock();
		stock1.setId("000001");
		stock1.setStatus("Available");
		stock1.setQuantity(10);
		stock1.setPrice(1000d);

		final Stock stock2 = new Stock();
		stock2.setId("000002");
		stock2.setStatus("Available");
		stock2.setQuantity(17);
		stock2.setPrice(2400d);

		final Stock stock3 = new Stock();
		stock3.setId("000003");
		stock3.setStatus("Available");
		stock3.setQuantity(100);
		stock3.setPrice(34000d);

		final Stock stock4 = new Stock();
		stock4.setId("000004");
		stock4.setStatus("OutOfStock");
		stock4.setQuantity(0);
		stock4.setPrice(1000d);

		final Stock stock5 = new Stock();
		stock5.setId("000005");
		stock5.setStatus("Available");
		stock5.setQuantity(24);
		stock5.setPrice(5000d);

		final Stock stock6 = new Stock();
		stock6.setId("000006");
		stock6.setStatus("OutOfStock");
		stock6.setQuantity(1);
		stock6.setPrice(1500d);

		data.add(stock1);
		data.add(stock2);
		data.add(stock3);
		data.add(stock3);
		data.add(stock4);
		data.add(stock5);
		data.add(stock6);
	}

	public List<Stock> getData() {
		return data;
	}
}
