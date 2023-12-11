package com.gumit.app.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gumit.app.entity.AllergenProduct;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ProductReposirtyTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void testProductRepository() {
		List<AllergenProduct> allergenProductList= productRepository.findById(31L).get().getAllergenProduct();
		assertNotNull(allergenProductList);
		
		for (AllergenProduct allergenProduct : allergenProductList) {
			log.info(allergenProduct.getProductId());
			log.info(allergenProduct.getAllergen().get(0).getFileName());
		}
		
		
	}

}
