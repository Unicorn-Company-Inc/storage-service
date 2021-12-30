package com.shopicorn.storage.importer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage/import")
public class ImportController {

	@Autowired
	ProductRepository repo;

	/**
	 * Imports the SVG file at ./file/import.svg and returns the count of imported
	 * entities.
	 * 
	 * @param clear set to <code>true</code> to clear the Database before importing.
	 * @return {@link ResponseEntity} holding the count of imported entities
	 */
	@GetMapping
	ResponseEntity<Long> importDB(@RequestParam(required = false) boolean clear) {
		if (clear) {
			repo.deleteAll();
		}
		
		// TODO: Import CSV File

		return ResponseEntity.ok(0L);
	}
}
