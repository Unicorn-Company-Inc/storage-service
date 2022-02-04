package com.shopicorn.storage.importer;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

	@Id
	long id;

	String name;

	String color;

	String category;

	String description;

	String manufacturer;

	LocalDate releaseDate;

	int stars;
}
