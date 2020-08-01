package com.jewellery.shop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jewellery.shop.model.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
	Categories findById(long id);
	Categories findByName(String name);
	//List<Categories> findAllByCategoriesByIdAsc();
}
