package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Configuration
public class DataSeeder {

	@Bean
	CommandLineRunner seedProducts(ProductRepository productRepository) {
		return args -> {
			long count = productRepository.count();
			if (count >= 10) {
				return;
			}
			for (int i = (int) count + 1; i <= 10; i++) {
				Product p = new Product();
				p.setName("Product " + i);
				p.setPrice(100 * i);
				productRepository.save(p);
			}
		};
	}
}
