package com.JPABasics.JPABasics;

import com.JPABasics.JPABasics.entities.ProductEntity;
import com.JPABasics.JPABasics.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaBasicsApplicationTests {

	@Autowired
	ProductRepository productRepository;
	@Test
	void contextLoads() {

	}

	@Test
	void testRepository(){
		ProductEntity productEntity=ProductEntity.builder()
				.sku("nestle")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();
		ProductEntity savedProductEntity=productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository(){
		List<ProductEntity> entities=productRepository.findByCreatedAtAfter(LocalDateTime.of(2025,1,1,0,0,0));
		System.out.println(entities);
	}

	@Test
	void getDetails(){
		List<ProductEntity> entities =productRepository.findByQuantityGreaterThanAndPriceLessThan(4,BigDecimal.valueOf(10.4));
		System.out.println(entities);
	}

	@Test
	void getDetailsUsingWildcards(){
//		List<ProductEntity> entities = productRepository.findByTitleLike("%Cola%");
		List<ProductEntity> myEntity = productRepository.findByTitleContainingIgnoreCase("cola");
//		System.out.println(entities);
		System.out.println(myEntity);
	}

	@Test
	void getSingleElement(){
//		Optional<ProductEntity> productEntity = productRepository.findByTitleAndPrice("Pepsi",BigDecimal.valueOf(14.4));
		Optional<ProductEntity> productEntity = productRepository.findByTitleAndPrice("Pepsi",BigDecimal.valueOf(14.4));
		productEntity.ifPresent(System.out::println);
	}



}
