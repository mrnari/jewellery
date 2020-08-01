package com.jewellery.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jewellery.shop.model.Categories;
import com.jewellery.shop.model.Product;
import com.jewellery.shop.services.CategoriesService;
import com.jewellery.shop.validatators.CategoriesValidator;

@Controller
public class CategoriesController {

	private static final Logger logger = LoggerFactory.getLogger(CategoriesController.class);
	private CategoriesService categoriesService = null;
	private CategoriesValidator categoriesValidator = new CategoriesValidator();

	@Autowired
	public CategoriesController(CategoriesService categoriesService, CategoriesValidator categoriesValidator) {
		this.categoriesService = categoriesService;
		this.categoriesValidator = categoriesValidator;
	}

	@GetMapping("/categories/new")
	public String newCategories(Model model) {
		model.addAttribute("categoriesForm", new Product());
		model.addAttribute("method", "new");
		return "categories";
	}

	@PostMapping("/categories/save")
	public String newCategories(@ModelAttribute("categoriesForm") Categories categoriesForm, BindingResult bindingResult, Model model) {
		categoriesValidator.validate(categoriesForm, bindingResult);

		if (bindingResult.hasErrors()) {
			logger.error(String.valueOf(bindingResult.getFieldError()));
			model.addAttribute("method", "new");
			return "categories";
		}
		categoriesService.save(categoriesForm);
		logger.debug(String.format("Categories With Id: %s Successfully Created.", categoriesForm.getId()));
		return "redirect:/home";
	}

	@GetMapping("/categories/edit/{id}")
	public String editCategories(@PathVariable("id") long categoriesId, Model model){
		Categories categories = categoriesService.findById(categoriesId);
		if (categories != null){
			model.addAttribute("categoriesForm", categories);
			model.addAttribute("method", "edit");
			return "categories";
		}else {
			return "error/404";
		}
	}

	@PostMapping("/categories/edit/{id}")
	public String editCategories(@PathVariable("id") long categoriesId, @ModelAttribute("categoriesForm") Categories categoriesForm, BindingResult bindingResult, Model model){
		categoriesValidator.validate(categoriesForm, bindingResult);

		if (bindingResult.hasErrors()) {
			logger.error(String.valueOf(bindingResult.getFieldError()));
			model.addAttribute("method", "edit");
			return "categories";
		}
		categoriesService.edit(categoriesId, categoriesForm);
		logger.debug(String.format("Product With id: %s has been Successfully Edited.", categoriesId));

		return "redirect:/home";
	}

	@PostMapping("/categories/delete/{id}")
	public String deleteProduct(@PathVariable("id") long categoriesId){
		Categories categories = categoriesService.findById(categoriesId);
		if (categories != null){
			categoriesService.delete(categoriesId);
			logger.debug(String.format("Product With id: %s Successfully Deleted.", categories.getId()));
			return "redirect:/home";
		}else {
			return "error/404";
		}
	}

		
}
