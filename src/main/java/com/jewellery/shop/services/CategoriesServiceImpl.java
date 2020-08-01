package com.jewellery.shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jewellery.shop.dao.CategoriesRepository;
import com.jewellery.shop.model.Categories;
import com.jewellery.shop.model.Product;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	private final CategoriesRepository categoriesRepository;

	@Autowired
	public CategoriesServiceImpl(CategoriesRepository categoriesRepository){
		this.categoriesRepository = categoriesRepository;
	}

	@Override
	public void save(Categories product) {
		categoriesRepository.save(product);
	}

	@Override
	public void edit(long id, Categories newProduct) {
		Categories found = categoriesRepository.getOne(id);
		found.setName(newProduct.getName());
		found.setImage(newProduct.getImage());
		found.setDescription(newProduct.getDescription());
		found.setPrice(newProduct.getPrice());
		save(newProduct);
	}

	@Override
	public void delete(long id) {
		categoriesRepository.delete(findById(id));
	}

	@Override
	public Categories findById(long id) {
		return categoriesRepository.findById(id);
	}

	@Override
	public List<Categories> findAllByCategoriesByIdAsc() {
		//return categoriesRepository.findAllByCategoriesByIdAsc();
		return null;
	}

	@Override
	public long count() {
		return categoriesRepository.count();
	}


}
