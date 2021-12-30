package com.shopicorn.storage.importer;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductEntity {

	@Id
	long id;

	String color;

	String category;

	String description;

	String manufacturer;

	LocalDate releaseDate;

	int stars;
}
