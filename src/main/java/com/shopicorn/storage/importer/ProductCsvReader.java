package com.shopicorn.storage.importer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.StreamSupport;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

class ProductCsvReader {
	private final File file;

	public ProductCsvReader(File csvFile) {
		this.file = csvFile;
	}

	public Collection<ProductEntity> readCsv() throws IOException {
		try (CSVParser csvParser = new CSVParser(Files.newBufferedReader(file.toPath()),
				CSVFormat.DEFAULT.withHeader());) {
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			return StreamSupport.stream(csvRecords.spliterator(), false).map(this::toProductEntity).toList();
		} catch (IOException e) {
			throw new IOException("Csv import failed", e);
		}
	}

	private ProductEntity toProductEntity(CSVRecord record) {
		long id = Long.parseLong(record.get("id"));
		String name = record.get("name");
		String color = record.get("color");
		String category = record.get("category");
		String description = record.get("description");
		String manufacturer = record.get("manufacturer");
		LocalDate releaseDate = LocalDate.parse(record.get("releaseDate"));
		int stars = Integer.parseInt(record.get("stars"));
		return new ProductEntity(id, name, color, category, description, manufacturer, releaseDate, stars);
	}
}
