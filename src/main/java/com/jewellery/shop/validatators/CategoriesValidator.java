package com.jewellery.shop.validatators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jewellery.shop.model.Categories;

@Component
public class CategoriesValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Categories.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Categories product = (Categories) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","error.not_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.not_empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "error.not_empty");

        // Name must have from 2 characters to 32
        if (product.getName().length() <= 1) {
            errors.rejectValue("name", "product.error.name.less_2");
        }
        if (product.getName().length() > 32) {
            errors.rejectValue("name", "product.error.name.over_32");
        }
    }
}
