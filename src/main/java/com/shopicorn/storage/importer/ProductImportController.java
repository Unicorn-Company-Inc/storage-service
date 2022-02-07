package com.shopicorn.storage.importer;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage/import")
public class ProductImportController {

	@Autowired
	ProductRepository repo;

	/**
	 * Import the CSV file at ./file/products.csv
	 */
	@GetMapping
	Collection<ProductEntity> importDB() throws IOException {
		// Reset Table
		repo.deleteAllInBatch();

		// Import CSV File
		var file = new File("file/products.csv");
		var reader = new ProductCsvReader(file);
		Collection<ProductEntity> entities = reader.readCsv();
		var saved = repo.saveAll(entities);

		// Return the imported products
		return saved;
	}
}
