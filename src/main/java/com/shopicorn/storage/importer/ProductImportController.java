package com.shopicorn.storage.importer;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage/import")
public class ProductImportController {

	@Autowired
	ProductRepository repo;

	/**
	 * Import the CSV file at ./file/import.scv and return the count of imported
	 * entities.
	 * 
	 * @param clear set to <code>true</code> to clear the Database before importing.
	 * @return {@link ResponseEntity} holding the count of imported entities
	 * @throws IOException Thrown when import fails
	 */
	@GetMapping
	ResponseEntity<Integer> importDB(@RequestParam(required = false) boolean clear) throws IOException {
		if (clear) {
			repo.deleteAll();
		}

		// Import CSV File
		var file = new File("file/import.csv");
		var reader = new ProductCsvReader(file);
		Collection<ProductEntity> entities = reader.readCsv();
		var saved = repo.saveAll(entities);

		// Return saved entity count
		return ResponseEntity.ok(saved.size());
	}
}
