package com.shopicorn.storage.stock;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController()
public class StockController {

	@Autowired
	StockRepository repo;

	final Supplier<RuntimeException> throwNotFound = () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
			"Stock not found");

	@GetMapping("/storage/stock/{id}")
	StockEntity get(@PathVariable long id) {
		var optional = repo.findById(id);
		var entity = optional.orElseThrow(throwNotFound);
		return entity;
	}
}
