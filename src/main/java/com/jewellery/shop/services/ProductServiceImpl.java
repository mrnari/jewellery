package com.jewellery.shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jewellery.shop.dao.ProductRepository;
import com.jewellery.shop.model.Product;

@Service
public class ProductServiceImpl  implements ProductService {

	private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void edit(long id, Product newProduct) {
        Product found = productRepository.getOne(id);
        found.setName(newProduct.getName());
        found.setImage(newProduct.getImage());
        found.setDescription(newProduct.getDescription());
        found.setPrice(newProduct.getPrice());
        save(newProduct);
    }

    @Override
    public void delete(long id) {
        productRepository.delete(findById(id));
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAllByProductsByIdAsc() {
        //return productRepository.findAllByProductsByIdAsc();
    	return null;
    }

    @Override
    public long count() {
        return productRepository.count();
    }
	
}
