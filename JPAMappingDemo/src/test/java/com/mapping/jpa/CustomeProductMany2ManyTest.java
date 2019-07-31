package com.mapping.jpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.mapping.jpa.entity.Customer;
import com.mapping.jpa.entity.Product;
import com.mapping.jpa.repository.CustomerRepository;
import com.mapping.jpa.repository.ProductRepository;

import oracle.net.aso.p;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomeProductMany2ManyTest {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void testA_customer_product_Save() {
		Customer customer = new Customer();
		customer.setName("Vishal");

		Product p1 = new Product();
		p1.setName("Computer");
		Product p2 = new Product();
		p2.setName("Mobile");

		p1 = productRepository.save(p1);
		p2 = productRepository.save(p2);

		assertNotNull(p1);
		assertTrue(p1.getId() > 0);

		assertNotNull(p2);
		assertTrue(p2.getId() > 0);

		List<Product> products = new ArrayList<>();
		products.add(p1);
		products.add(p2);

		customer.setProductList(products);

		customer = customerRepository.save(customer);
		assertNotNull(customer);
		assertTrue(customer.getId() > 0);

	}

	@Test
	@Transactional
	public void testB_customer_product_aSave() {
		Optional<Customer> customersOptional = customerRepository.findById(1);
		assertTrue(customersOptional.isPresent());
		Customer customer = customersOptional.get();
		assertNotNull(customer);

		System.out.println("Name of cusotmer : " + customer.getName());
		System.out.println("Product list : ");
		List<Product> products = customer.getProductList();
		for (Product product : products) {
			System.out.println(product.getName());
		}
	}
	
	@Test
	@Ignore
	public void testC_custome_produce_delete() {
		customerRepository.deleteById(1);
		System.out.println("Custome id 1 deleted");
		assertTrue(1==1);
	}
	@Test
	public void testD_custome_produce_delete() {
		productRepository.deleteById(1);
		System.out.println("Product id 1 deleted");
		assertTrue(1==1);
	}
}
