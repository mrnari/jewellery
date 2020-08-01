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

import com.jewellery.shop.model.Product;
import com.jewellery.shop.services.ProductService;
import com.jewellery.shop.validatators.ProductValidator;

@Controller
public class ProductsController {

	private static final Logger logger = LoggerFactory.getLogger(ProductsController.class);
	private ProductService productService = null;
	private ProductValidator productValidator = new ProductValidator();

	@Autowired
	public ProductsController(ProductService productService, ProductValidator productValidator) {
		this.productService = productService;
		this.productValidator = productValidator;
	}

	@GetMapping("/product/new")
	public String newProduct(Model model) {
		model.addAttribute("productForm", new Product());
		model.addAttribute("method", "new");
		return "product";
	}

	@PostMapping("/product/save")
	public String newProduct(@ModelAttribute("productForm") Product productForm, BindingResult bindingResult, Model model) {
		productValidator.validate(productForm, bindingResult);

		if (bindingResult.hasErrors()) {
			logger.error(String.valueOf(bindingResult.getFieldError()));
			model.addAttribute("method", "new");
			return "product";
		}
		productService.save(productForm);
		logger.debug(String.format("Product With id: %s Successfully Created.", productForm.getId()));

		return "redirect:/home";
	}

	@GetMapping("/product/edit/{id}")
	public String editProduct(@PathVariable("id") long productId, Model model){
		Product product = productService.findById(productId);
		if (product != null){
			model.addAttribute("productForm", product);
			model.addAttribute("method", "edit");
			return "product";
		}else {
			return "error/404";
		}
	}

	@PostMapping("/product/edit/{id}")
	public String editProduct(@PathVariable("id") long productId, @ModelAttribute("productForm") Product productForm, BindingResult bindingResult, Model model){
		productValidator.validate(productForm, bindingResult);

		if (bindingResult.hasErrors()) {
			logger.error(String.valueOf(bindingResult.getFieldError()));
			model.addAttribute("method", "edit");
			return "product";
		}
		productService.edit(productId, productForm);
		logger.debug(String.format("Product With id: %s has been Successfully Edited.", productId));

		return "redirect:/home";
	}

	@PostMapping("/product/delete/{id}")
	public String deleteProduct(@PathVariable("id") long productId){
		Product product = productService.findById(productId);
		if (product != null){
			productService.delete(productId);
			logger.debug(String.format("Product With id: %s Successfully Deleted.", product.getId()));
			return "redirect:/home";
		}else {
			return "error/404";
		}
	}



}
