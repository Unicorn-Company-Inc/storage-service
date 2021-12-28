package com.shopicorn.storage.stock;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StockEntity {
	@Id
	private long id;

	private int amount;
	private int deliveryTimeDays;
	private double price;
}
