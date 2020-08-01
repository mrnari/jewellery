package com.jewellery.shop.services;

import java.util.List;

import com.jewellery.shop.model.Product;

public interface ProductService {

	void save(Product product);
    void edit(long id, Product newProduct);
    void delete(long id);
    Product findById(long id);
    List<Product> findAllByProductsByIdAsc();
    long count();
	
}
