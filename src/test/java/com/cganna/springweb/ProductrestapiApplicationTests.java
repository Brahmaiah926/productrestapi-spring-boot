package com.cganna.springweb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.cganna.springweb.entities.Product;

@SpringBootTest
class ProductrestapiApplicationTests {

	@Value("${productrestapi.services.url}")
	private String baseURL;

	@Test
	public void testGetProduct() {
		System.out.println("The BaseURL is" + baseURL);

		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseURL + "/0", Product.class);

		assertNotNull(product);
	}

	@Test
	public void testCreateProduct() {
		System.out.println("The BaseURL is" + baseURL);

		RestTemplate restTemplate = new RestTemplate();

		Product testProduct = new Product();
		testProduct.setId(1);
		testProduct.setName("Trimmer");
		testProduct.setDescription("new Philip trimmer");
		testProduct.setPrice(2000);

		Product product = restTemplate.postForObject(baseURL, testProduct, Product.class);

		assertNotNull(product);
		assertNotNull(product.getId());
		assertEquals("Trimmer", testProduct.getName());
	}

	@Test
	public void testUpdateProduct() {

		RestTemplate restTemplate = new RestTemplate();

		Product testProduct = restTemplate.getForObject(baseURL + "/1", Product.class);

		testProduct.setPrice(3000);

		restTemplate.put(baseURL + "/1", testProduct);
	}

}
