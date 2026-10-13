package com.hritik.jpa.learnJpa;

import com.hritik.jpa.learnJpa.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LearnJpaApplicationTests {

	@Autowired
    ProductRepository productRepository; // instance of product repository injected using springboot

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {

	}

}
