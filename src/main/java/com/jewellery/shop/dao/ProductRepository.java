package com.jewellery.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jewellery.shop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findById(long id);
	Product findByName(String name);
	//List<Product> findAllByProductsByIdAsc();
}
