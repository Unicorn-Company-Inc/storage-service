package com.shopicorn.storage;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.shopicorn.storage.stock.StockEntity;
import com.shopicorn.storage.stock.StockRepository;

@SpringBootApplication
public class StorageServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner bootsrap(StockRepository repo) {
		return args -> {
			repo.save(new StockEntity(0, 5, 3, 10));
			repo.save(new StockEntity(1, 3, 3, 10));
			repo.save(new StockEntity(2, 3, 3, 15));
			repo.save(new StockEntity(3, 3, 3, 15));
			repo.save(new StockEntity(4, 2, 4, 20));
			repo.save(new StockEntity(5, 2, 4, 20));
			repo.save(new StockEntity(6, 2, 4, 30));
			repo.save(new StockEntity(7, 5, 4, 50));
			repo.save(new StockEntity(8, 5, 7, 100));
			repo.save(new StockEntity(9, 4, 7, 150));
		};
	}
}
