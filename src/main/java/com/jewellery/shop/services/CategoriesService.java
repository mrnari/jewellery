package com.jewellery.shop.services;

import java.util.List;

import com.jewellery.shop.model.Categories;

public interface CategoriesService {

	void save(Categories product);
    void edit(long id, Categories newProduct);
    void delete(long id);
    Categories findById(long id);
    List<Categories> findAllByCategoriesByIdAsc();
    long count();
	
}

